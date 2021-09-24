package io.betterbanking.service;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.MerchantDetailsRepository;
import io.betterbanking.repository.TransactionApiClient;
import io.betterbanking.repository.TransactionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @CircuitBreaker(name = "transactionService", fallbackMethod = "fallbackMethod")
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) throws Exception {
//        List<Transaction> transactionList = transactionApiClient.getTransactionByAccount(accountNumber);
//        transactionList.forEach(t-> {
//            t.setMerchantLogo(merchantDetailsRepository.getMerchantLogo(t.getMerchantName()).orElse(""));
//        });
//        return transactionList;
       List<Transaction> transactionList =  transactionRepository.findAllByAccountNumber(accountNumber);
       if(transactionList.isEmpty()){
           throw new Exception("No transaction");
       }
       return transactionList;
    }
    //fallback ==> get data from local
    private List<Transaction> fallbackMethod(final Integer accountNumber, final Throwable throwable) throws Exception{
            return pollByAccountNumber(accountNumber);
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

    @Scheduled(cron = "*/30 * * * * *")
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
