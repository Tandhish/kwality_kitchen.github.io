package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.model.main.Product;
import com.techorzo.kwality.kitchen.service.main.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) { this.productService = productService; }

    @PostMapping(path = "/add")
    public void addProduct(Product product) { productService.addProduct(product); }

    @GetMapping(path = "/get/id={id}")
    public Product getProductById(String p_id) {
        return productService.getProductById(p_id)
                .orElse(null);
    }

    @GetMapping(path = "/get/name={name}")
    public Product getProductByName(String name) {
        return productService.getProductByName(name)
                .orElse(null);
    }
}
