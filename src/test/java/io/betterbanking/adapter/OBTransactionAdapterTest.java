package io.betterbanking.adapter;

import com.acme.banking.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OBTransactionAdapterTest {
    @Test
    @DisplayName("Test all valid values")
    public void  testAllValidValues(){
        var ob6 = new OBTransaction6();
        ob6.setAccountId("123");
        ob6.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);

        OBMerchantDetails1 merchantDetails1 = new OBMerchantDetails1();
        merchantDetails1.setMerchantName("Lysa");
        ob6.setMerchantDetails(merchantDetails1);

        ob6.setValueDateTime(Date.valueOf(LocalDate.of(2020,9,14)));

        OBActiveOrHistoricCurrencyAndAmount9 amount9 = new OBActiveOrHistoricCurrencyAndAmount9();
        amount9.setAmount("100");
        ob6.setAmount(amount9);

        OBCurrencyExchange5 exchange5 = new OBCurrencyExchange5();
        exchange5.setUnitCurrency("USD");
        exchange5.setExchangeRate(BigDecimal.valueOf(1.27));
        ob6.setCurrencyExchange(exchange5);

        var tran = OBTransactionAdapter.transformOBTransaction6ToTransaction(ob6);

        assertEquals(123, tran.getAccountNumber());
        assertEquals("Credit", tran.getType());
        assertEquals("Lysa", tran.getMerchantName());
        assertEquals(127, tran.getAmount());
        assertEquals("USD", tran.getCurrency());
        assertEquals(Date.valueOf(LocalDate.of(2020,9,14)),tran.getDate());

    }
    @Test
    @DisplayName("Test all invalid values")
    public void testAllInvalidValues(){
        var ob6 = new OBTransaction6();
        var tran = OBTransactionAdapter.transformOBTransaction6ToTransaction(ob6);

        assertEquals(null, tran.getAccountNumber());
        assertEquals(null, tran.getType());
        assertEquals(null, tran.getMerchantName());
        assertEquals(0.0, tran.getAmount());
        assertEquals(null, tran.getCurrency());
        assertEquals(null,tran.getDate());
    }

    @Test
    @DisplayName("Test all invalid values")
    public void testSomeInvalidValues(){
        var ob6 = new OBTransaction6();

        ob6.setAccountId("111");
        ob6.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);

        OBMerchantDetails1 merchantDetails1 = new OBMerchantDetails1();
        merchantDetails1.setMerchantName("Don");
        ob6.setMerchantDetails(merchantDetails1);

        var tran = OBTransactionAdapter.transformOBTransaction6ToTransaction(ob6);

        assertEquals(111, tran.getAccountNumber());
        assertEquals("Debit", tran.getType());
        assertEquals("Don", tran.getMerchantName());
        assertEquals(0.0, tran.getAmount());
        assertEquals(null, tran.getCurrency());
        assertEquals(null,tran.getDate());
    }
}