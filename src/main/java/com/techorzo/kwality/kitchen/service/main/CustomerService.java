package com.techorzo.kwality.kitchen.service.main;

import com.techorzo.kwality.kitchen.dao.main.CustomerDao;
import com.techorzo.kwality.kitchen.model.main.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerSqlLite") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer) {
        if(customer.getUUID() == null) {
            return customerDao.insertCustomer(customer);
        } else {
            return customerDao.insertCustomer(customer.getUUID(), customer);
        }
    }
    
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Optional<Customer> getCustomerById(String uuid) {
        return customerDao.getCustomerByID(uuid);
    }
}
