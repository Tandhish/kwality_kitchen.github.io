package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.model.main.CompanyTransaction;
import com.techorzo.kwality.kitchen.service.main.CompanyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/company/transact")
@RestController
public class CompanyTransactionController {
    private final CompanyTransactionService transactionService;

    @Autowired
    public CompanyTransactionController(CompanyTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/add")
    public int addTransaction(@RequestBody CompanyTransaction transaction) {
            return transactionService.insertTransaction(transaction);
    }

    @GetMapping(path = "/get/id={id}")
    public CompanyTransaction getTransactionById(String t_id) {
        return transactionService.getTransactionById(t_id)
                .orElse(null);
    }

    @GetMapping(path = "/get/name={date}")
    public CompanyTransaction getTransactionByDate(String date) {
        return transactionService.getTransactionByDate(date)
                .orElse(null);
    }
}
