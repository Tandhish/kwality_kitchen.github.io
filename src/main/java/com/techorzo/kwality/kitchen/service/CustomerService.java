package com.techorzo.kwality.kitchen.service;

import com.techorzo.kwality.kitchen.dao.main.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("SqlLite") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
