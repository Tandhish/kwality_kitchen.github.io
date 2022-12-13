package com.techorzo.kwality.kitchen.model.credential;

public class CustomerCredential {
    private final String _customer_id;
    private final String _customer_password;
    private final String _customer_user_name;

    public String getCustomerID() { return _customer_id; }
    public String getCustomerPassword() { return _customer_password; }
    public String getCustomerUserName() { return _customer_user_name; }

    public CustomerCredential(String customer_id, String customer_password,
                              String customer_user_name) {
        _customer_id = customer_id;
        _customer_password = customer_password;
        _customer_user_name = customer_user_name;
    }
}
