package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.misc.Authorize;
import com.techorzo.kwality.kitchen.model.main.Product;
import com.techorzo.kwality.kitchen.service.main.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) { this.productService = productService; }

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product product) { productService.addProduct(product); }

    @GetMapping(path = "/token={token}/get/id={id}")
    public Product getProductById(@PathVariable("id") String p_id, @PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }
        return productService.getProductById(p_id)
                .orElse(null);
    }

    @GetMapping(path = "/token={token}/get/name={name}")
    public Product getProductByName(@PathVariable("name") String name, @PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }
        return productService.getProductByName(name)
                .orElse(null);
    }
}
