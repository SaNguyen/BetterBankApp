package io.betterbanking.adapter;

import com.acme.banking.model.OBTransaction6;
import io.betterbanking.entity.Transaction;

import java.util.Optional;
import java.util.function.Function;

public class OBTransactionAdapter {
    private static Function<OBTransaction6, Transaction> adaptFunction = obTransaction6 -> {

            Transaction tran = new Transaction();

            tran.setAccountNumber(transform(obTransaction6, o->Integer.valueOf(obTransaction6.getAccountId())).orElse(null));
            //transform(obTransaction6, o->Integer.valueOf(obTransaction6.getAccountId())).ifPresent(tran::setAccountNumber);

            tran.setType(transform(obTransaction6,o->obTransaction6.getCreditDebitIndicator().toString()).orElse(null));
            //transform(obTransaction6, o->obTransaction6.getCreditDebitIndicator().toString()).ifPresent(tran::setType);

            tran.setCurrency(transform(obTransaction6,o->obTransaction6.getCurrencyExchange().getUnitCurrency()).orElse(null));
            //transform(obTransaction6,o->obTransaction6.getCurrencyExchange().getUnitCurrency()).ifPresent(tran::setCurrency);

            tran.setMerchantName(transform(obTransaction6, o->obTransaction6.getMerchantDetails().getMerchantName()).orElse(null));
            //transform(obTransaction6, o->obTransaction6.getMerchantDetails().getMerchantName()).ifPresent(tran::setMerchantName);

            tran.setDate(transform(obTransaction6, o->obTransaction6.getValueDateTime()).orElse(null));
            //transform(obTransaction6, o->obTransaction6.getValueDateTime()).ifPresent(tran::setDate);

            Double amount =  transform(obTransaction6,o-> Double.valueOf(obTransaction6.getAmount().getAmount())).orElse(0.0);
            Double rate =  transform(obTransaction6,o-> obTransaction6.getCurrencyExchange().getExchangeRate().doubleValue()).orElse(0.0);
            tran.setAmount(amount * rate);

            return tran;

    };

    public static Transaction transformOBTransaction6ToTransaction(OBTransaction6 obTransaction6) {
        return adaptFunction.apply(obTransaction6);
    }

    private static <T> Optional<T> transform(OBTransaction6 obTransaction6, Function<OBTransaction6, T> func){
        try{
            return Optional.of(func.apply(obTransaction6));
        }catch(Exception e){
//            System.out.println("Exception:  "  + e.getMessage());
            return Optional.empty();
        }
    }

//    public static Transaction tranferFromOBTransaction6ToTransaction(OBTransaction6 obTransaction6){
//        Transaction tran = new Transaction();
//        try {
//            tran.setAccountNumber(Integer.valueOf(obTransaction6.getAccountId()));
//            tran.setType(obTransaction6.getCreditDebitIndicator().toString());
//            tran.setCurrency(obTransaction6.getCurrencyExchange().getUnitCurrency());
//            tran.setMerchantName(obTransaction6.getMerchantDetails().getMerchantName());
//            tran.setDate(obTransaction6.getValueDateTime());
//
//            Double amount = Double.valueOf(obTransaction6.getAmount().getAmount());
//            Double rate = obTransaction6.getCurrencyExchange().getExchangeRate().doubleValue();
//            tran.setAmount(amount*rate);
//            return tran;
//        } catch (Exception e){
//            return null;
//        }
//    }
}




