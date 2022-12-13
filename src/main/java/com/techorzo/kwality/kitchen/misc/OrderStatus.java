package com.techorzo.kwality.kitchen.misc;

public enum OrderStatus {
    FAILED ("Transaction Failed"),
    SUCCESS ("Transaction Successful"),
    PENDING ("Transaction Pending");

    private final String _name;

    OrderStatus(String s) {
        _name = s;
    }

    public boolean equals(String name) {
        return _name.equals(name);
    }

    public String toString() {
        return _name;
    }
}
