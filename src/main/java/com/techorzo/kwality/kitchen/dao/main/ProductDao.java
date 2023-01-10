package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.model.main.Product;
import com.techorzo.kwality.kitchen.uuid.CustomUUID;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    int insertProduct(String p_id, Product product);

    int deleteProduct(String p_id);

    Optional<Product> getProductByID(String p_id);

    Optional<Product> getProductByName(String name);

    default int insertCustomer(Product product) { return insertProduct(CustomUUID.getStringUUID(), product); }

    default Product makeProduct(List<String> strings) {
        /* p_id, p_amt, p_des, p_name */
        return new Product(strings.get(0), new BigDecimal(strings.get(1)), strings.get(2), strings.get(3));
    }
}
