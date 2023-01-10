package com.techorzo.kwality.kitchen.dao.credential;

import com.techorzo.kwality.kitchen.misc.EmployeeType;
import com.techorzo.kwality.kitchen.model.credential.EmployeeCredential;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.util.List;
import java.util.Optional;

public interface EmployeeCredentialDao {
    int insertEmployeeCredential(String employee_id, EmployeeCredential credential);

    int deleteEmployeeCredential(String employee_id);

    Optional<EmployeeCredential> getEmployeeCredentialByID(String employee_id);

    Optional<EmployeeCredential> getEmployeeCredentialByName(String name);

    default int insertEmployeeCredential(EmployeeCredential credential) {
        return insertEmployeeCredential(CustomUUID.getStringUUID(), credential);
    }

    default EmployeeCredential makeEmployeeCredential(List<String> str) {
        return new EmployeeCredential(str.get(0), str.get(1), EmployeeType.valueOf(str.get(2)), str.get(3));
    }
}
