package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.model.main.DeliveryEmployee;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.util.List;
import java.util.Optional;

public interface DeliveryEmployeeDao {
    int insertDeliveryEmployee(String employee_id, DeliveryEmployee deliveryEmployee);

    int deleteDeliveryEmployee(String employee_id);

    Optional<DeliveryEmployee> getDeliveryEmployeeByID(String employee_id);

    Optional<DeliveryEmployee> getDeliveryEmployeeByName(String name);

    default int insertDeliveryEmployee(DeliveryEmployee deliveryEmployee) {
        return insertDeliveryEmployee(CustomUUID.getStringUUID(), deliveryEmployee);
    }

    default DeliveryEmployee makeDeliveryEmployee(List<String> str) {
        return new DeliveryEmployee(str.get(0), str.get(1), str.get(2), str.get(3));
    }
}
