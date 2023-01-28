package com.techorzo.kwality.kitchen.dao.credential;

import com.techorzo.kwality.kitchen.model.credential.CustomerCredential;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.util.List;
import java.util.Optional;

public interface CustomerCredentialDao {
    int insertCustomerCredential(String cust_id, CustomerCredential credential);

    int deleteCustomerCredential(String cust_id);

    Optional<CustomerCredential> getCustomerCredentialByID(String cust_id);

    Optional<CustomerCredential> getCustomerCredentialByName(String name);

    default int insertCustomerCredential(CustomerCredential credential) {
        return insertCustomerCredential(CustomUUID.getStringUUID(credential.getCustomerID()), credential);
    }

    default CustomerCredential makeCustomerCredential(List<String> str) {
        return new CustomerCredential(str.get(0), str.get(1), str.get(2));
    }
}
