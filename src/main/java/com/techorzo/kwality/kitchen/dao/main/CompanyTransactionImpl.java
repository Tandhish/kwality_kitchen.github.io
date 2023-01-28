package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.CompanyTransaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("CompanyTransactionSqlLite")
public class CompanyTransactionImpl implements CompanyTransactionDao{
    private final SqlHandler handler;

    public CompanyTransactionImpl() { handler = SqlHandler.getMainInstance(); }

    @Override
    public int insertTransaction(String t_id, CompanyTransaction transaction) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "Insert into Company_Transaction (Transaction_ID, Transaction_Amount, Transaction_Date, Transaction_Status) values (?,?,?,?);";
                res = handler.executeUpdate(query, t_id, transaction.getTransactionAmount(), transaction.getTransactionDate(), transaction.getTransactionDate());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int deleteTransaction(String t_id) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM Company_Transaction WHERE Transaction_ID=?;";
                res = handler.executeUpdate(query, t_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Optional<CompanyTransaction> getTransactionByID(String t_id) {
        List<CompanyTransaction> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Company_Transaction WHERE Transaction_ID=?;";
                List<List<String>> r = handler.executeQuery(query, t_id);
                for(List<String> strings : r) {
                    res.add(makeTransaction(strings));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res.stream()
                .findFirst();
    }

    @Override
    public Optional<CompanyTransaction> getTransactionByDate(String date) {
        List<CompanyTransaction> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Company_Transaction WHERE Transaction_Date=?;";
                List<List<String>> r = handler.executeQuery(query, date);
                for(List<String> strings : r) {
                    res.add(makeTransaction(strings));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }
}
