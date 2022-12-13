package com.techorzo.kwality.kitchen;

import com.techorzo.kwality.kitchen.misc.XmlParser;

import java.util.Currency;
import java.util.Locale;

public class Test2 {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();



//        (new Thread(() -> {
//            System.out.println(parser.getStringByID("test"));
//        })).start();
//
//        (new Thread(() -> {
//            System.out.println(parser.getStringByID("habba"));
//        })).start();

        Currency currency = Currency.getInstance("INR");


        System.out.println(currency.getSymbol());
    }
}
