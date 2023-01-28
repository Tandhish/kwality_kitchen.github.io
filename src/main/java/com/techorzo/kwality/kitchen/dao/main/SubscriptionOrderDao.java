package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.OrderStatus;
import com.techorzo.kwality.kitchen.model.main.SubscriptionOrder;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.util.List;
import java.util.Optional;

public interface SubscriptionOrderDao {
    int insertSubscriptionOrder(String transaction_id, SubscriptionOrder subscriptionOrder);

    int deleteSubscriptionOrder(String transaction_id);

    Optional<SubscriptionOrder> getSubscriptionOrderByID(String transaction_id);

    Optional<SubscriptionOrder> getSubscriptionOrderByDate(String date);

    default int insertSubscriptionOrder(SubscriptionOrder subscriptionOrder) {
        return insertSubscriptionOrder(CustomUUID.getStringUUID(subscriptionOrder.getCustomerID()), subscriptionOrder);
    }

    default SubscriptionOrder makeSubscriptionOrder(List<String> str) {
        return new SubscriptionOrder(str.get(0), str.get(1), str.get(2), OrderStatus.valueOf(str.get(3)), str.get(4));
    }
}
