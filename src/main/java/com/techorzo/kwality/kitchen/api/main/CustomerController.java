package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.model.main.Customer;
import com.techorzo.kwality.kitchen.service.main.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }

    @PostMapping(path = "/add")
    public void addCustomers(@RequestBody List<Customer> customers) {
        for(Customer c : customers) {
            customerService.addCustomer(c);
        }
    }

    @GetMapping(path = "/get/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/get/id={id}")
    public Customer getCustomerById(@PathVariable("id") String uuid) {
        return customerService.getCustomerById(uuid)
                .orElse(null);
    }
}
