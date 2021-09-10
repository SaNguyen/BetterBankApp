package io.betterbanking.dto;

import io.betterbanking.entity.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TransactionDto {
    private Integer id;
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    public static TransactionDto apply(Transaction t){
        TransactionDto dto = TransactionDto.builder()
                .id(t.getId())
                .type(t.getType())
                .date(t.getDate())
                .accountNumber(t.getAccountNumber())
                .currency(t.getCurrency())
                .amount(t.getAmount())
                .merchantLogo(t.getMerchantLogo())
                .merchantName(t.getMerchantName())
                .build();
        return dto;
    }
}
