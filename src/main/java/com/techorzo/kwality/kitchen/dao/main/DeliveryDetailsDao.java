package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.model.main.DeliveryDetails;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.util.List;
import java.util.Optional;

public interface DeliveryDetailsDao {
    int insertDeliveryDetails(String delivery_id, DeliveryDetails deliveryDetails);

    int deleteDeliveryDetails(String delivery_id);

    Optional<DeliveryDetails> getDeliveryDetailsByID(String delivery_id);


    //ToDo: Send List
    Optional<DeliveryDetails> getDeliveryDetailsByDate(String delivery_date);

    default int insertDeliveryDetails(DeliveryDetails deliveryDetails) {
        return insertDeliveryDetails(CustomUUID.getStringUUID(), deliveryDetails);
    }

    default DeliveryDetails makeDeliveryDetails(List<String> str) {
        return new DeliveryDetails(str.get(0), str.get(1), str.get(2), str.get(3), str.get(4));
    }
}
