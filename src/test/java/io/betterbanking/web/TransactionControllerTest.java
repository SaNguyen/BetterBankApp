package io.betterbanking.web;

import io.betterbanking.BetterBankingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllByAccountNumber() throws Exception {

        mockMvc.perform(get("/api/v1/transactions/1"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.[0].type").value("credit"))
                        .andExpect(jsonPath("$.[0].accountNumber").value(1))
                        .andExpect(jsonPath("$.[0].currency").value("USD"))
                        .andExpect(jsonPath("$.[0].amount").value(100.0));


    }
}