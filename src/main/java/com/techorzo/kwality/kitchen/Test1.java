package com.techorzo.kwality.kitchen;

import com.techorzo.kwality.kitchen.dao.main.CustomerDao;
import com.techorzo.kwality.kitchen.dao.main.CustomerImpl;
import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.misc.XmlParser;
import com.techorzo.kwality.kitchen.model.main.Customer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Test1 {
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Main.class, args);

        SqlHandler handler = SqlHandler.getInstance();

        // jdbc:sqlite:D:\Projects\kwality_kitchen\src\main\resources\test.db
        String url = "jdbc:sqlite:D://Projects/kwality_kitchen/src/main/resources/databases/Main_Database_test.db";
        handler.connectDB(url);



        CustomerDao customerDao = new CustomerImpl();

        List<Customer> res = customerDao.getAllCustomers();
        for(Customer customer : res) {
            for(String s : customer) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        Customer c1 = customerDao.getCustomerByID("Habba").orElse(null);
        System.out.println("Customer with UUID \"Habba\" : ");
        if(c1 != null) {
            for (String s : c1) {
                System.out.print(s + "\t");
            }
        }
        System.out.println();

        c1 = customerDao.getCustomerByID("aaa").orElse(null);

        System.out.println("Customer with UUID \"aaa\" : ");
        if(c1 != null) {
            for (String s : c1) {
                System.out.print(s + "\t");
            }
        }
    }
}
