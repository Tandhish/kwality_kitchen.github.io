package com.techorzo.kwality.kitchen.misc;

public enum EmployeeType {
    STAFF ("staff"),
    COOK ("cook");

    private final String _name;

    private EmployeeType(String s) { _name = s; }

    public boolean equals(String o) { return _name.equals(o); }

    public String toString() { return _name; }
}
