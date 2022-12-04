package com.techorzo.kwality.kitchen;

import com.techorzo.kwality.kitchen.misc.XmlParser;

public class Test2 {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();



        (new Thread(() -> {
            System.out.println(parser.getStringByID("test"));
        })).start();

        (new Thread(() -> {
            System.out.println(parser.getStringByID("habba"));
        })).start();
    }
}
