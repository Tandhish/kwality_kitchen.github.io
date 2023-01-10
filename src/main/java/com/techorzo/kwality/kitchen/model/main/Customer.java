package com.techorzo.kwality.kitchen.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techorzo.kwality.kitchen.misc.XmlParser;

import java.util.Iterator;

public class Customer implements Iterable<String> {
    private final String _uuid;
    private final String _user_name;
    private final String _email;
    private final String _phone_contact;
    private final String _address;

    public String getUUID() { return _uuid; }
    public String getUserName() { return _user_name; }
    public String getEmail() { return _email; }
    public String getContact() { return _phone_contact; }
    public String getAddress() { return _address; }


    public Customer(@JsonProperty("uuid") String uuid,@JsonProperty("username") String username,
                    @JsonProperty("email") String email,
                    @JsonProperty("contact") String contact,@JsonProperty("address") String address) {
        _uuid = uuid;
        _user_name = username;
        _email = email;
        _phone_contact = contact;
        _address = address;
    }

    public String get(int i) {
        return switch (i) {
            case 0 -> getUUID();
            case 1 -> getUserName();
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
