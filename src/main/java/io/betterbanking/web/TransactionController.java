package io.betterbanking.web;

import io.betterbanking.dto.TransactionDto;
import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountNumber}")
    public List<Transaction> findAllByAccountNumber(@PathVariable("accountNumber") final Integer accountNumber) throws Exception{
        return transactionService.findAllByAccountNumber(accountNumber);

    }


}
