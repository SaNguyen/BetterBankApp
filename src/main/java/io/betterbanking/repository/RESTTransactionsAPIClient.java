package io.betterbanking.repository;

import com.acme.banking.model.OBReadTransaction6;
import io.betterbanking.adapter.OBTransactionAdapter;
import io.betterbanking.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import static java.util.stream.Collectors.toList;
@SuppressWarnings("deprecation")
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient {
    private String baseUrl;
    /*atributes*/
    private WebClient webClient;
    private static DefaultOAuth2AccessToken oAuth2AccessToken = null;

    @Value("${basic.auth.encoded.credential}")
    private String encodeCcredential;
    //////////////////////////////////////////////////////////////////////////
//
    @Autowired
    public RESTTransactionsAPIClient(WebClient webClient) {
        this.webClient = webClient;
    }


    /*getter, setter*/

    public static void setoAuth2AccessToken(DefaultOAuth2AccessToken accessToken) {
        oAuth2AccessToken = accessToken;
    }

    public static DefaultOAuth2AccessToken getoAuth2AccessToken() {
        return oAuth2AccessToken;
    }
    /////////////////////////////////////////////////////////////////////////


    public DefaultOAuth2AccessToken getACMEBankingAuthToken(){
        DefaultOAuth2AccessToken authReponse = null;

        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("grant_type","client_credentials");
        try{
            authReponse = webClient.post()
                    .uri("/oauth/token")
                    .header("Authorization", "Basic " + encodeCcredential)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromFormData(bodyValues))
                    .retrieve()
                    .bodyToMono(DefaultOAuth2AccessToken.class)
                    .block();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return authReponse;
    }

    @Override
    public List<Transaction> getTransactionByAccount(Integer accountNumber) throws Exception {
        if(oAuth2AccessToken == null || oAuth2AccessToken.isExpired()) {
            System.out.println("Create new token");
            oAuth2AccessToken = getACMEBankingAuthToken();
        }
         if(oAuth2AccessToken == null || oAuth2AccessToken.getValue() == null)
            return null;

        String accessToken = oAuth2AccessToken.getValue();
        OBReadTransaction6 tranResponse = null;
        try {
            tranResponse = webClient.get()
                    .uri("/accounts/" + accountNumber.toString() + "/transactions")
                    .headers(h -> h.setBearerAuth(accessToken))
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(OBReadTransaction6.class)
                    .block();
        } catch (Exception ex) {
            throw ex;
        }

        if (tranResponse != null && tranResponse.getData() != null)
            return tranResponse.getData()
                    .getTransaction()
                    .stream()
                    .map(OBTransactionAdapter::transformOBTransaction6ToTransaction)
                    .collect(toList());

        return null;
    }

}
