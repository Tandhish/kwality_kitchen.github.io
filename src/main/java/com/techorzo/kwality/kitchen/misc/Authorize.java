package com.techorzo.kwality.kitchen.misc;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/*
Should only run while the server is running, hence no database required
 */
public class Authorize {

private volatile List<String> _authorizedUsers;
private volatile List<String> _authorizedEmployee;


    public synchronized boolean isAuthorized(String id) {
        System.out.println("ID :: " + id);
        if(!_authorizedUsers.contains(id)) {
            return _authorizedEmployee.contains(id);
        }
        return true;
    }


    // id should be id+pass
    public synchronized String newAuthorize(String id) {
        for(String s : _authorizedUsers) {
            if(Objects.equals(id, s)) {
                return s;
            }
        }

        _authorizedUsers.add(id);

        return id;
    }

    public synchronized String newAuthorizeEmployee(String id) {
        for(String s : _authorizedEmployee) {
            if(Objects.equals(id, s)) {
                return s;
            }
        }

        _authorizedEmployee.add(id);

        return id;
    }


    private Authorize() {
        _authorizedUsers = new ArrayList<>();
        _authorizedEmployee = new ArrayList<>();
    }


    public synchronized static Authorize getInstance() { return HOLDER._Instance; }

    private static final class HOLDER {
        private static final Authorize _Instance = new Authorize();
    }
}
