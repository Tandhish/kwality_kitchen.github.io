package com.techorzo.kwality.kitchen.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Currency;

public class Product {
    private final String _product_id;
    private final BigDecimal _product_amount;
    private final String _product_description;
    private final String _product_name;

    public String getProductID() { return _product_id; }
    public BigDecimal getProductAmount() { return _product_amount; }
    public String getProductDescription() { return _product_description; }
    public String getProductName() { return _product_name; }

    public Product(@JsonProperty("p_id") String product_id,@JsonProperty("p_amt") BigDecimal product_amount,
                   @JsonProperty("desc") String product_description,@JsonProperty("p_name") String product_name) {
        _product_id = product_id;
        _product_amount = product_amount;
        _product_description = product_description;
        _product_name = product_name;
    }
}
