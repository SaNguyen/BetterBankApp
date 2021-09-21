package io.betterbanking.repository;

import com.acme.banking.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.betterbanking.BetterBankingApplication;
import io.betterbanking.entity.Transaction;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
@SuppressWarnings("deprecation")
@SpringBootTest(classes={BetterBankingApplication.class})
public class RESTTransactionsAPIClientTest {
    private static MockWebServer mockWebServer;
    private static DefaultOAuth2AccessToken mockAccessToken = mock(DefaultOAuth2AccessToken.class);

    private TransactionApiClient transactionApiClient;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    static void setup() throws IOException{
        mockWebServer =  new MockWebServer();
        mockWebServer.start();
        mockAccessToken = mock(DefaultOAuth2AccessToken.class);
    }
    @AfterAll
    static void stop() throws IOException{
        mockWebServer.shutdown();
    }

    @BeforeEach
    void initialize(){
        String baseUrl = String.format("http://%s:%s",mockWebServer.getHostName(), mockWebServer.getPort());
        Mockito.when(mockAccessToken.getValue()).thenReturn("1234567890");
        Mockito.when(mockAccessToken.isExpired()).thenReturn(false);

        RESTTransactionsAPIClient.setoAuth2AccessToken(mockAccessToken);

        WebClient webClient = WebClient.create(baseUrl);
        transactionApiClient = new RESTTransactionsAPIClient(webClient);
    }

    @DisplayName("Test getTransactionByAccount using MockWebServer")
    @Test
    public void testGetTransactionByAccount() throws Exception{
        MockWebServer server =  new MockWebServer();

        //expected of external API endpoint
        OBReadTransaction6 obReadTransaction6 = new OBReadTransaction6();
        OBReadDataTransaction6 obReadDataTransaction6 = new OBReadDataTransaction6();

        OBTransaction6 obTransaction6_1 = new OBTransaction6();
        obTransaction6_1.setTransactionId("1");
        obTransaction6_1.setAccountId("111");
        obTransaction6_1.setCreditDebitIndicator(OBCreditDebitCode1.CREDIT);

        OBTransaction6 obTransaction6_2 = new OBTransaction6();
        obTransaction6_2.setTransactionId("2");
        obTransaction6_2.setAccountId("111");
        obTransaction6_2.setCreditDebitIndicator(OBCreditDebitCode1.DEBIT);

        obReadDataTransaction6.setTransaction(List.of(obTransaction6_1,obTransaction6_2));
        obReadTransaction6.setData(obReadDataTransaction6);

        server.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(obReadTransaction6))
                .addHeader("Content-Type", "application-json")
                );
        //actual result
        List<Transaction> actualTrans = transactionApiClient.getTransactionByAccount(111);
        assertThat(actualTrans,hasSize(2));
    }
}