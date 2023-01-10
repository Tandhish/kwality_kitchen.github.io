package com.techorzo.kwality.kitchen.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployee {
    private final String _employee_id;
    private final String _employee_address;
    private final String _employee_name;
    private final String _employee_phone;

    public String getEmployeeID() { return _employee_id; }
    public String getEmployeeAddress() { return _employee_address; }
    public String getEmployeeName() { return _employee_name; }
    public String getEmployeePhone() { return _employee_phone; }

    public DeliveryEmployee(@JsonProperty("employee_id") String employee_id,@JsonProperty("employee_address") String employee_address,
                            @JsonProperty("employee_name") String employee_name,@JsonProperty("employee_phone") String employee_phone) {
        _employee_id = employee_id;
        _employee_address = employee_address;
        _employee_name = employee_name;
        _employee_phone = employee_phone;
    }
}
