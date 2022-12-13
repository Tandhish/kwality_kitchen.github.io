package com.techorzo.kwality.kitchen.model.order;

public class SubscriptionOrder {
    private final String _product_id;
    private final String _daily_order_id;

    public String getProductID() { return _product_id; }
    public String getDailyOrderID() { return _daily_order_id; }

    public SubscriptionOrder(String product_id, String daily_order_id) {
        _product_id = product_id;
        _daily_order_id = daily_order_id;
    }
}
