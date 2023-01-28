package com.techorzo.kwality.kitchen;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Test1 {
    public static void main(String[] args) throws Exception {
        SqlHandler handler = SqlHandler.getMainInstance();

        // jdbc:sqlite:D:\Projects\kwality_kitchen\src\main\resources\test.db
        String url = "jdbc:sqlite:D://Projects/kwality_kitchen/src/main/resources/databases/Main_Database_test.db";
        handler.connectDB(url);


        SpringApplication.run(Test1.class, args);
    }
}
