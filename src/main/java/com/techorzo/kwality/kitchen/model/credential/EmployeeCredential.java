package com.techorzo.kwality.kitchen.model.credential;

import com.techorzo.kwality.kitchen.misc.EmployeeType;

public class EmployeeCredential {
    private final String _employee_id;
    private final String _employee_password;
    private final EmployeeType _employee_type;
    private final String _employee_user_name;

    public String getEmployeeID() { return _employee_id; }
    public String getEmployeePassword() { return _employee_password; }
    public EmployeeType getEmployeeType() { return _employee_type; }
    public String getEmployeeUserName() { return _employee_user_name; }

    public EmployeeCredential(String employee_id, String employee_password,
                              EmployeeType employee_type, String employee_user_name) {
        _employee_id = employee_id;
        _employee_password = employee_password;
        _employee_type = employee_type;
        _employee_user_name = employee_user_name;
    }
}
