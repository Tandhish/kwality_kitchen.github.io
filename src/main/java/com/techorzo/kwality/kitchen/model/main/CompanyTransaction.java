package com.techorzo.kwality.kitchen.model.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techorzo.kwality.kitchen.misc.OrderStatus;

import java.math.BigDecimal;

public class CompanyTransaction {
    private final String _transaction_id;
    private final BigDecimal _transaction_amount;
    private final String _transaction_date;
    private final OrderStatus _transaction_status;

    public String getTransactionID() { return _transaction_id; }
    public BigDecimal getTransactionAmount() { return _transaction_amount; }
    public String getTransactionDate() { return _transaction_date; }
    public OrderStatus getTransactionStatus() { return _transaction_status; }

    public CompanyTransaction(@JsonProperty("transaction_id") String transaction_id,@JsonProperty("transaction_amount") BigDecimal transaction_amount,
                              @JsonProperty("transaction_date") String transaction_date,@JsonProperty("transaction_status") OrderStatus transaction_status) {
        _transaction_id = transaction_id;
        _transaction_amount = transaction_amount;
        _transaction_date = transaction_date;
        _transaction_status = transaction_status;
    }
}
