package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.OrderStatus;
import com.techorzo.kwality.kitchen.model.main.CompanyTransaction;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CompanyTransactionDao {
    int insertTransaction(String t_id, CompanyTransaction transaction);

    int deleteTransaction(String t_id);

    Optional<CompanyTransaction> getTransactionByID(String t_id);

    Optional<CompanyTransaction> getTransactionByDate(String date);


    default int insertTransaction(CompanyTransaction transaction) { return insertTransaction(CustomUUID.getStringUUID(transaction.getTransactionAmount().toString(), transaction.getTransactionDate()), transaction); }

    default CompanyTransaction makeTransaction(List<String> str) {
        System.out.println(str.get(1));
        return new CompanyTransaction(str.get(0), new BigDecimal(str.get(1)), str.get(2), OrderStatus.valueOf(str.get(3)));
    }
}
