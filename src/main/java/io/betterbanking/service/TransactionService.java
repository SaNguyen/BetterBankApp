package io.betterbanking.service;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.MerchantDetailsRepository;
import io.betterbanking.repository.TransactionApiClient;
import io.betterbanking.repository.TransactionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TransactionService {
    @Autowired
    private TransactionApiClient transactionApiClient;

    @Autowired
    private MerchantDetailsRepository  merchantDetailsRepository;

    @Autowired
    private TransactionRepository transactionRepository;

//    @Value("${testnet.integration.scheduled.poll}")
//    private final String cronJob;

    @Cacheable(cacheNames = "transactions")
    @CircuitBreaker(name = "transactionService", fallbackMethod = "fallbackMethod")
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) throws Exception {
        log.info("inside findAllByAccountNumber, get data from remote");
        return pollByAccountNumber(accountNumber);

    }
    //fallback ==> get data from local
    private List<Transaction> fallbackMethod(final Integer accountNumber, final Throwable throwable) throws Exception{
        log.info("falling back to local database to get transactions");
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }

    public List<Transaction> pollByAccountNumber(Integer accountNumber) throws Exception{
        List<Transaction> testnetTrans =  transactionApiClient.getTransactionByAccount(accountNumber);
        testnetTrans.forEach(t->{
            merchantDetailsRepository.getMerchantLogo(t.getMerchantName()).ifPresent(t::setMerchantName);
        });

        List<Transaction> localTrans = transactionRepository.findAllByAccountNumber(accountNumber);
        testnetTrans.forEach(t ->{
            if(!localTrans.contains(t)){
                transactionRepository.save(t);
            }
        });
        return testnetTrans;
    }

//    @Scheduled(cron = "*/30 * * * * *")
    public void pollRemoteTransactions(){
        log.info("Start polling all transactions from remote");
        List<Integer> accounts = transactionRepository.findAllAccount();
        accounts.forEach(acc->{
            try {
                this.pollByAccountNumber(acc);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
        log.info("Done!");
    }
}
