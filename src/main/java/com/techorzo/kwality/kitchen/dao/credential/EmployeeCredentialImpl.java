package com.techorzo.kwality.kitchen.dao.credential;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.credential.EmployeeCredential;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeCredentialImpl implements EmployeeCredentialDao{
    private final SqlHandler handler;

    public EmployeeCredentialImpl() { handler = SqlHandler.getCredentialInstance(); }

    @Override
    public int insertEmployeeCredential(String employee_id, EmployeeCredential credential) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "INSERT INTO employee_credentials (Employee_ID, Employee_Password, Employee_Type, Employee_User_Name) values (?,?,?,?);";
                res = handler.executeUpdate(query, employee_id, credential.getEmployeePassword(), credential.getEmployeeType(), credential.getEmployeeUserName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int deleteEmployeeCredential(String employee_id) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM employee_credentials WHERE Employee_ID=?;";
                res = handler.executeUpdate(query, employee_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Optional<EmployeeCredential> getEmployeeCredentialByID(String employee_id) {
        List<EmployeeCredential> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM employee_credentials WHERE Employee_ID=?;";
                List<List<String>> r = handler.executeQuery(query, employee_id);
                for(List<String> strings : r) {
                    res.add(makeEmployeeCredential(strings));
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
    public Optional<EmployeeCredential> getEmployeeCredentialByName(String name) {
        List<EmployeeCredential> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM employee_credentials WHERE Employee_User_Name=?;";
                List<List<String>> r = handler.executeQuery(query, name);
                for(List<String> strings : r) {
                    res.add(makeEmployeeCredential(strings));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }
}
