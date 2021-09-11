package io.betterbanking.web;

import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.actuate.metrics.AutoConfigureMetrics;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest(classes={BetterBankingApplication.class})
@AutoConfigureMockMvc
class TransactionComponentTestRestAssuredMockMvc {

    @MockBean
    private TransactionService transactionService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    @DisplayName("TestEndToEnd2 using RestAssuredMockMvc")
    public void  TestEndToEnd2(){
        Mockito.when(transactionService.findAllByAccountNumber(anyInt())).thenReturn(
                List.of(
                        Transaction
                                .builder()
                                .type("credit")
                                .date(new Date())
                                .accountNumber(111)
                                .currency("USD")
                                .amount(100.00)
                                .merchantName("acme")
                                .merchantLogo("images/acme-logo.png")
                                .build()
                ));
        RestAssuredMockMvc.
                given()
                //.standaloneSetup(new TransactionController(new TransactionService()))

                .when()
                .get("/api/v1/transactions/111")
                .then()
                .statusCode(200)
                .body(("[0].type"),equalTo("credit"))
                .body(("[0].merchantName"),equalTo("acme"));
    }
}