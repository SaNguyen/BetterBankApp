package io.betterbanking.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Builder
@Data
@Getter
public class Transaction {
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;
}
