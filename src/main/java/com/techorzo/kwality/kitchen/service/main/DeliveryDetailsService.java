package com.techorzo.kwality.kitchen.service.main;

import com.techorzo.kwality.kitchen.dao.main.DeliveryDetailsDao;
import com.techorzo.kwality.kitchen.model.main.DeliveryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryDetailsService {
    public final DeliveryDetailsDao detailsDao;

    @Autowired
    public DeliveryDetailsService(@Qualifier("DeliveryDetailsSqlLite") DeliveryDetailsDao detailsDao) {
        this.detailsDao = detailsDao;
    }

    public int insertDetails(DeliveryDetails details) {
        if(details.getDeliveryID() == null) {
            return detailsDao.insertDeliveryDetails(details);
        } else {
            return detailsDao.insertDeliveryDetails(details.getDeliveryID(), details);
        }
    }

    public Optional<DeliveryDetails> getDetailsById(String d_id) {
        return detailsDao.getDeliveryDetailsByID(d_id);
    }

    public Optional<DeliveryDetails> getDetailsByDate(String date) {
        return detailsDao.getDeliveryDetailsByDate(date);
    }
}
