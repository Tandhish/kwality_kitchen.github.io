package com.techorzo.kwality.kitchen.model.main;

public class DeliveryDetails {
    private final String _delivery_id;
    private final String _delivery_date;
    private final String _employee_id;
    private final String _product_id;
    private final String _scheduled_time;

    public String getDeliveryID() { return _delivery_id; }
    public String getDeliveryDate() { return _delivery_date; }
    public String getEmployeeID() { return _employee_id; }
    public String getProductID() { return _product_id; }
    public String getScheduledTime() { return _scheduled_time; }

    public DeliveryDetails(String delivery_id, String delivery_date,
                           String employee_id, String product_id,
                           String scheduled_time) {
        _delivery_id = delivery_id;
        _delivery_date = delivery_date;
        _employee_id = employee_id;
        _product_id = product_id;
        _scheduled_time = scheduled_time;
    }
}
