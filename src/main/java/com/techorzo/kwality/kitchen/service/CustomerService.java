package com.techorzo.kwality.kitchen.service;

import com.techorzo.kwality.kitchen.dao.CustomerDao;

public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
