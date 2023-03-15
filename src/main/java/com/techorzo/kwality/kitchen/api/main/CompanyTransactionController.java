package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.misc.Authorize;
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

    @PostMapping(path = "/token={token}/add")
    public int addTransaction(@RequestBody CompanyTransaction transaction, @PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return -1;
        }
            return transactionService.insertTransaction(transaction);
    }

    @GetMapping(path = "/token={token}/get/id={id}")
    public CompanyTransaction getTransactionById(@PathVariable("id") String t_id, @PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }

        return transactionService.getTransactionById(t_id)
                .orElse(null);
    }

    @GetMapping(path = "/token={token}/get/date={date}")
    public CompanyTransaction getTransactionByDate(@PathVariable("date") String date, @PathVariable("token") String token) {

        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }
        return transactionService.getTransactionByDate(date)
                .orElse(null);
    }
}
