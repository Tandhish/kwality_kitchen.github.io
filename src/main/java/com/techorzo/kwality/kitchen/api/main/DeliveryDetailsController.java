package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.model.main.DeliveryDetails;
import com.techorzo.kwality.kitchen.service.main.DeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/delivery/details")
@RestController
public class DeliveryDetailsController {
    private final DeliveryDetailsService detailsService;

    @Autowired
    public DeliveryDetailsController(DeliveryDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @PostMapping(path = "/add")
    public int addDeliveryDetails(@RequestBody DeliveryDetails details) {
        return detailsService.insertDetails(details);
    }

    @GetMapping(path = "/get/id={id}")
    public DeliveryDetails getDetailsById(@PathVariable("id") String d_id) {
        return detailsService.getDetailsById(d_id)
                .orElse(null);
    }

    @GetMapping(path = "/get/date={date}")
    public DeliveryDetails getDetailsByDate(@PathVariable("date") String date) {
        return detailsService.getDetailsByDate(date)
                .orElse(null);
    }
}
