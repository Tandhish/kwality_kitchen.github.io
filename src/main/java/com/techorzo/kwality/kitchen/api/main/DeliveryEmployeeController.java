package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.dao.main.DeliveryEmployeeDao;
import com.techorzo.kwality.kitchen.model.main.DeliveryEmployee;
import com.techorzo.kwality.kitchen.service.main.DeliveryEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/delivery/employee")
public class DeliveryEmployeeController {
    private final DeliveryEmployeeService employeeService;

    @Autowired
    public DeliveryEmployeeController(DeliveryEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public int addDeliveryEmployee(DeliveryEmployee employee) {
        return employeeService.insertDeliveryEmployee(employee);
    }

    public DeliveryEmployee getEmployeeById(String id) {
        return employeeService.getDeliveryEmployeeById(id)
                .orElse(null);
    }

    public DeliveryEmployee getEmployeeByName(String name) {
        return employeeService.getDeliveryEmployeeByName(name)
                .orElse(null);
    }
}
