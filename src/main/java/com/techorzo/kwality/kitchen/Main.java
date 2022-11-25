package com.techorzo.kwality.kitchen;

import com.techorzo.kwality.kitchen.dao.CustomerDao;
import com.techorzo.kwality.kitchen.dao.CustomerImpl;
import com.techorzo.kwality.kitchen.misc.SqlHandler;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Main.class, args);

        SqlHandler handler = SqlHandler.getInstance();

        // jdbc:sqlite:D:\Projects\kwality_kitchen\src\main\resources\test.db
        String url = "jdbc:sqlite:D://Projects/kwality_kitchen/src/main/resources/test.db";
        handler.connectDB(url);


//        String query = "Insert into customer (UUID, UserName, Email, Contact, Address, SignUp) values (?, ?, ?, ?, ?, ?);";
//        handler.executeUpdate(query,  "H", "h", "h@h.com", "1234", "noa asoid aosd - 50060", "21/22/2222");

        CustomerDao customerDao = new CustomerImpl();



        List<List<String>> res;
        res = handler.executeQuery("Select * from customer");
        handler.executeUpdate("commit;");
        if(res == null) {
            return;
        }
        for(List<String> r : res) {
            for(String s : r) {
                System.out.println(s);
            }
        }
    }
}
