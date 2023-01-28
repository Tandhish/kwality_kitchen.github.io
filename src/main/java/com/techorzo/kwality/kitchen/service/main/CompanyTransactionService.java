package com.techorzo.kwality.kitchen.service.main;

import com.techorzo.kwality.kitchen.dao.main.CompanyTransactionDao;
import com.techorzo.kwality.kitchen.model.main.CompanyTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyTransactionService {
    private final CompanyTransactionDao transactionDao;

    @Autowired
    public CompanyTransactionService(@Qualifier("CompanyTransactionSqlLite") CompanyTransactionDao companyTransactionDao) {
        this.transactionDao = companyTransactionDao;
    }

    public int insertTransaction(CompanyTransaction companyTransaction) {
        if(companyTransaction.getTransactionID() == null) {
            return transactionDao.insertTransaction(companyTransaction);
        } else {
            return transactionDao.insertTransaction(companyTransaction.getTransactionID(), companyTransaction);
        }
    }

    public Optional<CompanyTransaction> getTransactionById(String t_id) { return transactionDao.getTransactionByID(t_id); }

    public Optional<CompanyTransaction> getTransactionByDate(String date) { return transactionDao.getTransactionByDate(date); }
}
