package com.techorzo.kwality.kitchen.dao;

import com.techorzo.kwality.kitchen.model.Customer;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    int insertCustomer(String uuid, Customer customer);

    int deleteCustomer(String uuid);

    Optional<Customer> getCustomerByID(String uuid);

    Optional<List<Customer>> getCustomerByName(String name);

    List<Customer> getAllCustomers();


    default int insertCustomer(Customer customer) {
        return insertCustomer(CustomUUID.getStringUUID(), customer);
    }

    default Customer makeCustomer(List<String> str) {
        /*  UUID, UserName, SignUp, Email, Contact, Address */
        return new Customer(str.get(0), str.get(1), str.get(2), str.get(3), str.get(4), str.get(5));
    }
}
