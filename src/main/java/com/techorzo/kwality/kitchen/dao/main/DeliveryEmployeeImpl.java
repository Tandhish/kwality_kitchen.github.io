package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.DeliveryEmployee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("DeliveryEmployeeSqlLite")
public class DeliveryEmployeeImpl implements DeliveryEmployeeDao{
    private final SqlHandler handler;

    public DeliveryEmployeeImpl() { handler = SqlHandler.getMainInstance(); }

    @Override
    public int insertDeliveryEmployee(String employee_id, DeliveryEmployee deliveryEmployee) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "INSERT INTO Delivery_Employee (Employee_ID, Employee_Address, Employee_Name, Employee_Phone) values (?,?,?,?);";
                res = handler.executeUpdate(query, employee_id, deliveryEmployee.getEmployeeAddress(), deliveryEmployee.getEmployeeName(), deliveryEmployee.getEmployeePhone());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int deleteDeliveryEmployee(String employee_id) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM Delivery_Employee WHERE Employee_ID=?;";
                res = handler.executeUpdate(query, employee_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Optional<DeliveryEmployee> getDeliveryEmployeeByID(String employee_id) {
        List<DeliveryEmployee> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Delivery_Employee WHERE Employee_ID=?;";
                List<List<String>> r = handler.executeQuery(query, employee_id);
                for(List<String> strings : r) {
                    res.add(makeDeliveryEmployee(strings));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res.stream()
                .findFirst();
    }

    @Override
    public Optional<DeliveryEmployee> getDeliveryEmployeeByName(String name) {
        List<DeliveryEmployee> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Delivery_Employee WHERE Employee_Name=?;";
                List<List<String>> r = handler.executeQuery(query, name);
                for(List<String> strings : r) {
                    res.add(makeDeliveryEmployee(strings));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }
}
