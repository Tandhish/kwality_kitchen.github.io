package com.techorzo.kwality.kitchen.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techorzo.kwality.kitchen.misc.OrderStatus;

public class SubscriptionOrder {
    private final String _cust_id;
    private final String _product_id;
    private final String _sub_order_date;
    private OrderStatus _sub_order_status;
    private final String _transaction_id;

    public String getCustomerID() { return _cust_id; }
    public String getProductID() { return _product_id; }
    public String getSubscriptionOrderDate() { return _sub_order_date; }
    public OrderStatus getSubscriptionOrderStatus() { return _sub_order_status; }
    public String getTransactionID() { return _transaction_id; }

    public void setSubscriptionOrderStatus(OrderStatus status) { _sub_order_status = status; }

    public SubscriptionOrder(String cust_id, String product_id,
                             String sub_order_date, String transaction_id) {
        _cust_id = cust_id;
        _product_id = product_id;
        _sub_order_date = sub_order_date;
        _transaction_id = transaction_id;

        _sub_order_status = OrderStatus.PENDING;
    }

    public SubscriptionOrder(@JsonProperty("uuid") String cust_id,@JsonProperty("p_id") String product_id,@JsonProperty("order_date") String sub_order_date,
                             @JsonProperty("order_status") OrderStatus sub_order_status,@JsonProperty("t_id") String transaction_id) {
        _cust_id = cust_id;
        _product_id = product_id;
        _sub_order_date = sub_order_date;
        _sub_order_status = sub_order_status;
        _transaction_id = transaction_id;
    }
}
