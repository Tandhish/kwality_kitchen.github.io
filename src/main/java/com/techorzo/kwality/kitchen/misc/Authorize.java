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


    public synchronized boolean isAuthorized(String id) {
        return _authorizedUsers.contains(id);
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


    private Authorize() {
        _authorizedUsers = new ArrayList<>();
    }


    public synchronized static Authorize getInstance() { return HOLDER._Instance; }

    private static final class HOLDER {
        private static final Authorize _Instance = new Authorize();
    }
}
