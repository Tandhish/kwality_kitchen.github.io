package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.misc.Authorize;
import com.techorzo.kwality.kitchen.model.main.DeliveryEmployee;
import com.techorzo.kwality.kitchen.service.main.DeliveryEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/delivery/employee")
public class DeliveryEmployeeController {
    private final DeliveryEmployeeService employeeService;

    @Autowired
    public DeliveryEmployeeController(DeliveryEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/token={token}/add")
    public int addDeliveryEmployee(@RequestBody DeliveryEmployee employee,@PathVariable("token") String token) {

        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return -1;
        }
        return employeeService.insertDeliveryEmployee(employee);
    }

    @GetMapping(path = "/token={token}/get/id={id}")
    public DeliveryEmployee getEmployeeById(@PathVariable("id") String id,@PathVariable("token") String token) {

        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }

        return employeeService.getDeliveryEmployeeById(id)
                .orElse(null);
    }

    @GetMapping(path = "/token={token}/get/name={name}")
    public DeliveryEmployee getEmployeeByName(@PathVariable("name") String name,@PathVariable("token") String token) {

        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }

        return employeeService.getDeliveryEmployeeByName(name)
                .orElse(null);
    }
}
