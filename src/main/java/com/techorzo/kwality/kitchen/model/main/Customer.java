package com.techorzo.kwality.kitchen.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Iterator;

public class Customer implements Iterable<String> {
    private final String _uuid;
    private final String _user_name;
    private final String _sign_up_date;
    private final String _email;
    private final String _phone_contact;
    private final String _address;

    public String getUUID() { return _uuid; }
    public String getUserName() { return _user_name; }
    public String getSignUpDate() { return _sign_up_date; }
    public String getEmail() { return _email; }
    public String getContact() { return _phone_contact; }
    public String getAddress() { return _address; }


    public Customer(@JsonProperty("") String uuid, String username,
                    String date, String email,
                    String contact, String address) {
        _uuid = uuid;
        _user_name = username;
        _sign_up_date = date;
        _email = email;
        _phone_contact = contact;
        _address = address;
    }

    public String get(int i) {
        return switch (i) {
            case 0 -> getUUID();
            case 1 -> getUserName();
            case 2 -> getSignUpDate();
            case 3 -> getEmail();
            case 4 -> getContact();
            case 5 -> getAddress();
            default -> "N/A";
        };
    }

    public Iterator<String> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < 6;
        }

        @Override
        public String next() {
            return get(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() not implemented for : " + this);
        }
    }
}
