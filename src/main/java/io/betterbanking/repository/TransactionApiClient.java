package io.betterbanking.repository;

import io.betterbanking.entity.Transaction;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;

import java.util.List;

public interface TransactionApiClient {
    List<Transaction> getTransactionByAccount(Integer accountNumber) throws Exception;
}
