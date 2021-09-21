package io.betterbanking.repository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class MerchantDetailsRepositoryImpl implements MerchantDetailsRepository {
    @Override
    public Optional<String> getMerchantLogo(String merchantName) {
        if(merchantName != null){
            return Optional.of(merchantName.toLowerCase() + "-logo.pnj");
        }
        return Optional.empty();
    }
}
