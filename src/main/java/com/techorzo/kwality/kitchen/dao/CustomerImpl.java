package com.techorzo.kwality.kitchen.dao;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerImpl implements CustomerDao{
    private SqlHandler handler;

    public CustomerImpl() {
        handler = SqlHandler.getInstance();
    }


    @Override
    public int insertCustomer(String uuid, Customer customer) {
        int res = -1; // returns rows affected

        if(handler.isConnectedDB()) {
            try {
                String query = "Insert into customer (UUID, UserName, Email, Contact, Address, SignUp) values (?, ?, ?, ?, ?, ?);";
                res = handler.executeUpdate(query, customer.getUUID(), customer.getUserName(), customer.getEmail(), customer.getContact(), customer.getAddress(), customer.getSignUpDate().toString());
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
                String query = "DELETE FROM customer WHERE UUID=?";
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
                String query = "SELECT * FROM customer WHERE UUID=?;";
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
                String query = "SELECT * FROM customer WHERE UserName=?;";
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
                String query = "SELECT * FROM customer;";
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
