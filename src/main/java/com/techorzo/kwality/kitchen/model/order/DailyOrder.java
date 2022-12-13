package com.techorzo.kwality.kitchen.model.order;

import com.techorzo.kwality.kitchen.misc.OrderStatus;

public class DailyOrder {
    private final String _daily_order_id;
    private final String _order_date;
    private final OrderStatus _order_status;
    private final String _product_id;
    private final String _scheduled_time;

    public String getDailyOrderID() { return _daily_order_id; }
    public String getOrderDate() { return _order_date; }
    public OrderStatus getOrderStatus() { return _order_status; }
    public String getProductID() { return _product_id; }
    public String getScheduledTime() { return _scheduled_time; }

    public DailyOrder(String daily_order_id, String order_date,
                      OrderStatus order_status, String product_id,
                      String scheduled_time) {
        _daily_order_id = daily_order_id;
        _order_date = order_date;
        _order_status = order_status;
        _product_id = product_id;
        _scheduled_time = scheduled_time;
    }
}
