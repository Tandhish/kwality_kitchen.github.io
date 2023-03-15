package com.techorzo.kwality.kitchen.api.main;

import com.techorzo.kwality.kitchen.misc.Authorize;
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

    @PostMapping(path = "/token={token}/add")
    public int addDeliveryDetails(@RequestBody DeliveryDetails details,@PathVariable("token") String token) {

        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return -1;
        }
        return detailsService.insertDetails(details);
    }

    @GetMapping(path = "/token={token}/get/id={id}")
    public DeliveryDetails getDetailsById(@PathVariable("id") String d_id,@PathVariable("token") String token) {

        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }

        return detailsService.getDetailsById(d_id)
                .orElse(null);
    }

    @GetMapping(path = "/token={token}/get/date={date}")
    public DeliveryDetails getDetailsByDate(@PathVariable("date") String date,@PathVariable("token") String token) {
        Authorize authorize = Authorize.getInstance();
        if(!authorize.isAuthorized(token)) {
            return null;
        }

        return detailsService.getDetailsByDate(date)
                .orElse(null);
    }
}
