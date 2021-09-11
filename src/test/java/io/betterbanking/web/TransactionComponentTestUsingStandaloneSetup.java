package io.betterbanking.web;

import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;
import io.restassured.mapper.TypeRef;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.Map;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest(classes = {BetterBankingApplication.class})
public class TransactionComponentTestUsingStandaloneSetup {
    @Autowired
    private TransactionController transactionController;

    @Test
    @DisplayName("TestEndToEnd using standaloneSetup")
    public void  TestEndToEnd(){
        List<Map<String, Object>> transactions =
                RestAssuredMockMvc.
                    given()
                            .standaloneSetup(transactionController)
                            .auth().none()
                            .when()
                        .get("/api/v1/transactions/111")
                    .as(new TypeRef<List<Map<String, Object>>>() {});
//        System.out.println(transactions);
        assertThat(transactions,hasSize(1));
        assertThat(transactions.get(0).get("type"), equalTo("credit"));
        assertThat(transactions.get(0).get("accountNumber"), equalTo(111));
        assertThat(transactions.get(0).get("merchantName"), equalTo("acme"));
        assertThat(transactions.get(0).get("amount"), equalTo(100.0));

    }


}
