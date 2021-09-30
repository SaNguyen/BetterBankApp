package io.betterbanking.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(type, that.type) && Objects.equals(date, that.date)
                && Objects.equals(accountNumber, that.accountNumber)
                && Objects.equals(currency, that.currency)
                && Objects.equals(amount, that.amount)
                && Objects.equals(merchantName, that.merchantName);
    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(id, type, date, accountNumber, currency, amount, merchantName, merchantLogo);
//    }
}
