package com.techorzo.kwality.kitchen.service.credential;

import com.techorzo.kwality.kitchen.dao.credential.CustomerCredentialDao;
import com.techorzo.kwality.kitchen.model.credential.CustomerCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerCredentialService {
    private final CustomerCredentialDao credentialDao;

    @Autowired
    public CustomerCredentialService(@Qualifier("CustomerCredentialSqlLite") CustomerCredentialDao credentialDao) {
        this.credentialDao = credentialDao;
    }

    public int insertCredential(CustomerCredential credential) {
        if(credential.getCustomerID() == null) {
            return credentialDao.insertCustomerCredential(credential);
        } else {
            return credentialDao.insertCustomerCredential(credential.getCustomerID(), credential);
        }
    }

    public Optional<CustomerCredential> getCredentialById(String id) {
        return credentialDao.getCustomerCredentialByID(id);
    }

    public Optional<CustomerCredential> getCredentialByName(String name) {
        return credentialDao.getCustomerCredentialByName(name);
    }
}
