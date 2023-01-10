package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("SqlLite")
public class ProductImpl implements ProductDao{
    private final SqlHandler handler;

    public ProductImpl() { handler = SqlHandler.getInstance(); }

    @Override
    public int insertProduct(String p_id, Product product) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "Insert into Product (Product_ID, Product_Amount, Product_Description, Product_Name) values (?, ?, ?, ?);";
                res = handler.executeUpdate(query, p_id, product.getProductAmount(), product.getProductDescription(), product.getProductName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    @Override
    public int deleteProduct(String p_id) {
        int res = -1;
        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM Product WHERE Product_ID=?;";
                res = handler.executeUpdate(query, p_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    @Override
    public Optional<Product> getProductByID(String p_id) {
        List<Product> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Product WHERE Product_ID=?;";
                List<List<String>> r = handler.executeQuery(query, p_id);
                for(List<String> s : r) {
                    res.add(makeProduct(s));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        List<Product> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Product WHERE Product_Name=?;";
                List<List<String>> r = handler.executeQuery(query, name);
                for(List<String> s : r) {
                    res.add(makeProduct(s));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return res.stream()
                .findFirst();
    }
}
