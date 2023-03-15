package com.techorzo.kwality.kitchen.service.main;

import com.techorzo.kwality.kitchen.dao.main.ProductDao;
import com.techorzo.kwality.kitchen.model.main.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("ProductSqlLite") ProductDao productDao) { this.productDao = productDao; }

    public int addProduct(Product product) {
        if(product.getProductID() == null) {
            return productDao.insertProduct(product);
        } else {
            return productDao.insertProduct(product.getProductID(), product);
        }
    }

    public Optional<Product> getProductById(String p_id) { return productDao.getProductByID(p_id); }

    public Optional<Product> getProductByName(String name) { return productDao.getProductByName(name); }
}
