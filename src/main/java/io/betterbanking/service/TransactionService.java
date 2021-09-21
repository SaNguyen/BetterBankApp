package io.betterbanking.service;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.MerchantDetailsRepository;
import io.betterbanking.repository.TransactionApiClient;
import io.betterbanking.repository.TransactionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionApiClient transactionApiClient;

    @Autowired
    private MerchantDetailsRepository  merchantDetailsRepository;

    @CircuitBreaker(name = "transactionService", fallbackMethod = "fallbackMethod")
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) {
        List<Transaction> transactionList = transactionApiClient.getTransactionByAccount(accountNumber);
        transactionList.forEach(t-> {
            t.setMerchantLogo(merchantDetailsRepository.getMerchantLogo(t.getMerchantName()).orElse(""));
        });
        return transactionList;
    }

    private List<Transaction> fallbackMethod(final Integer accountNumber, Exception e){
        System.out.println("OpenBanking service is down!");
        return Collections.emptyList();
    }
}
