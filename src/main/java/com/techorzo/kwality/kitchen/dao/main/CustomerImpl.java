package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("SqlLite")
public class CustomerImpl implements CustomerDao{
    private final SqlHandler handler;

    public CustomerImpl() {
        handler = SqlHandler.getInstance();
    }


    @Override
    public int insertCustomer(String uuid, Customer customer) {
        int res = -1; // returns rows affected

        if(handler.isConnectedDB()) {
            try {
                String query = "Insert into Customer (Customer_ID, Customer_Address, Customer_Email, Customer_Name, Customer_Phone) values (?, ?, ?, ?, ?);";
                res = handler.executeUpdate(query, uuid, customer.getAddress(), customer.getEmail(), customer.getUserName(), customer.getContact());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    @Override
    public int deleteCustomer(String uuid) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM Customer WHERE Customer_ID=?";
                res = handler.executeUpdate(query, uuid);
            } catch (Exception e) {
                System.out.println("Error :: " + e.getMessage());
            }
        }

        return res;
    }

    @Override
    public Optional<Customer> getCustomerByID(String uuid) {
        List<Customer> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM customer WHERE Customer_ID=?;";
                List<List<String>> r = handler.executeQuery(query, uuid);
                for(List<String> strings : r) {
                    res.add(makeCustomer(strings));
                    break;
                }

            } catch (Exception e) {
                System.out.println("ERROR :: " + e.getMessage());
            }
        }
        return res.stream()
                .findFirst();
    }

    @Override
    public Optional<Customer> getCustomerByName(String name) {
        List<Customer> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM customer WHERE Customer_Name=?;";
                List<List<String>> r = handler.executeQuery(query, name);
                for(List<String> strings : r) {
                    res.add(makeCustomer(strings));
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error ::" + e.getMessage());
            }
        }
        return res.stream()
                .findFirst();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Customer;";
                List<List<String>> r = handler.executeQuery(query);
                for(List<String> strings : r) {
                    res.add(makeCustomer(strings));
                }
            } catch (Exception e) {
                System.out.println("Error :: " + e.getMessage());
            }
        }
        return res;
     }
}
