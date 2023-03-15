package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.misc.Authorize;
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

    @PostMapping(path = "/token={token}/add")
    public void addCustomers(@RequestBody List<Customer> customers,@PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return;
        }
        for(Customer c : customers) {
            customerService.addCustomer(c);
        }
    }

    @GetMapping(path = "/token={token}/get/all")
    public List<Customer> getAllCustomers(@PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/token={token}/get/id={id}")
    public Customer getCustomerById(@PathVariable("id") String uuid,@PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }
        return customerService.getCustomerById(uuid)
                .orElse(null);
    }
}
