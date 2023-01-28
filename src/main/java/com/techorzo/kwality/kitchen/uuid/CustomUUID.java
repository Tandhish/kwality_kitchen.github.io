package com.techorzo.kwality.kitchen.uuid;



/*
ToDO:
 > Static instance should instantiated at the very start
 > Generate UUID from Username + Account Creation date (?)
 > Check for Duplicates (Mostly queries from Database)
 > [Add More Here]
 */

import org.apache.tomcat.util.net.openssl.ciphers.Encryption;

import java.util.*;

public class CustomUUID {
    private static List<String> _uid_list;

    public synchronized static String getStringUUID(String ...values) {
        StringBuilder builder = new StringBuilder();

        for(String s : values) {
            builder.append(s);
            builder.append("-");
        }
        builder.append(UUID.randomUUID());

        return builder.toString();
    }


    public void updateList() {
        //Update UUIDs from database
    }

    public synchronized CustomUUID getInstance() {
        return _HOLDER._INSTANCE;
    }
    private CustomUUID() {
        _uid_list = new ArrayList<>();
    }

    private static class _HOLDER {
        private static final CustomUUID _INSTANCE = new CustomUUID();
    }
}
