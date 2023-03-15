package com.techorzo.kwality.kitchen.service.main;

import com.techorzo.kwality.kitchen.dao.main.SubscriptionOrderDao;

public class SubscriptionOrderService {
    private final SubscriptionOrderDao orderDao;

    public SubscriptionOrderService(SubscriptionOrderDao orderDao) {
        this.orderDao = orderDao;
    }

}
