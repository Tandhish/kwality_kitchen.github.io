package com.techorzo.kwality.kitchen.service.main;

import com.techorzo.kwality.kitchen.dao.main.DeliveryEmployeeDao;
import com.techorzo.kwality.kitchen.model.main.DeliveryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryEmployeeService {
    private final DeliveryEmployeeDao employeeDao;

    @Autowired
    public DeliveryEmployeeService(@Qualifier("DeliveryEmployeeSqlLite") DeliveryEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public int insertDeliveryEmployee(DeliveryEmployee employee) {
        if(employee.getEmployeeID() == null) {
            return employeeDao.insertDeliveryEmployee(employee);
        } else {
            return employeeDao.insertDeliveryEmployee(employee.getEmployeeID(), employee);
        }
    }

    public Optional<DeliveryEmployee> getDeliveryEmployeeById(String id) {
        return employeeDao.getDeliveryEmployeeByID(id);
    }

    public Optional<DeliveryEmployee> getDeliveryEmployeeByName(String name) {
        return employeeDao.getDeliveryEmployeeByName(name);
    }
}
