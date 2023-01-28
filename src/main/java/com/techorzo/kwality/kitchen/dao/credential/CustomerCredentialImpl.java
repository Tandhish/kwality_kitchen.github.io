package com.techorzo.kwality.kitchen.dao.credential;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.credential.CustomerCredential;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("CustomerCredentialSqlLite")
public class CustomerCredentialImpl implements CustomerCredentialDao {
    private final SqlHandler handler;

    public CustomerCredentialImpl() { handler = SqlHandler.getCredentialInstance(); }

    @Override
    public int insertCustomerCredential(String cust_id, CustomerCredential credential) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "INSERT INTO customer_credentials (Customer_ID, Customer_Password, Customer_User_Name) values (?,?,?);";
                res = handler.executeUpdate(query, cust_id, credential.getCustomerPassword(), credential.getCustomerUserName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int deleteCustomerCredential(String cust_id) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM customer_credentials WHERE Customer_ID=?;";
                res = handler.executeUpdate(query, cust_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Optional<CustomerCredential> getCustomerCredentialByID(String cust_id) {
        List<CustomerCredential> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM customer_credentials WHERE Customer_ID=?;";
                List<List<String>> r = handler.executeQuery(query, cust_id);
                for(List<String> strings : r) {
                    res.add(makeCustomerCredential(strings));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }

    @Override
    public Optional<CustomerCredential> getCustomerCredentialByName(String name) {
        List<CustomerCredential> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM customer_credentials WHERE Customer_User_Name=?;";
                List<List<String>> r = handler.executeQuery(query, name);
                for(List<String> strings : r) {
                    res.add(makeCustomerCredential(strings));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }
}
