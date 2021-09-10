package io.betterbanking.service;

import io.betterbanking.entity.Transaction;
import io.betterbanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public List<Transaction> findAllByAccountNumber(final Integer accountNumber) {
        return transactionRepository.findAllByAccountNumber(accountNumber);
//        return List.of(
//                 Transaction
//                .builder()
//                .type("credit")
//                .date(new Date())
//                .accountNumber(accountNumber)
//                .currency("USD")
//                .amount(100.00)
//                .merchantName("acme")
//                .merchantLogo("images/acme-logo.png")
//                .build()
//        );
    }
}
