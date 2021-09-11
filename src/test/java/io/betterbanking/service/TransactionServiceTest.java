package io.betterbanking.service;

import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes={BetterBankingApplication.class})
class TransactionServiceTest {
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Test
    void findAllByAccountNumber() {
        List<Transaction> re =  transactionService.findAllByAccountNumber(111);
        assertNotNull(re);
        assertEquals(1, re.size());
        assertNotEquals(10, re.size());
        assertEquals("credit", re.get(0).getType());
        assertEquals(111, re.get(0).getAccountNumber());
        assertEquals("USD", re.get(0).getCurrency());
        assertEquals(100.00, re.get(0).getAmount());
        assertEquals("acme", re.get(0).getMerchantName());
        assertEquals("images/acme-logo.png", re.get(0).getMerchantLogo());
        assertTrue((new Date()).after(re.get(0).getDate()));

    }
}