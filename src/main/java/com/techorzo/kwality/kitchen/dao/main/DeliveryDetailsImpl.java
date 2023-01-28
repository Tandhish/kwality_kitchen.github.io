package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.DeliveryDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("DeliveryDetailsSqlLite")
public class DeliveryDetailsImpl implements DeliveryDetailsDao{
    private final SqlHandler handler;

    public DeliveryDetailsImpl() { handler = SqlHandler.getMainInstance(); }


    @Override
    public int insertDeliveryDetails(String delivery_id, DeliveryDetails deliveryDetails) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "INSERT INTO Delivery_Details (Delivery_ID, Delivery_Date, Employee_ID, Product_ID, Scheduled_Time) values(?,?,?,?,?);";
                res = handler.executeUpdate(query, delivery_id, deliveryDetails.getDeliveryDate(), deliveryDetails.getEmployeeID(), deliveryDetails.getProductID(), deliveryDetails.getScheduledTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int deleteDeliveryDetails(String delivery_id) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM Delivery_Details WHERE Delivery_ID=?;";
                res = handler.executeUpdate(query, delivery_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Optional<DeliveryDetails> getDeliveryDetailsByID(String delivery_id) {
        List<DeliveryDetails> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Delivery_Details WHERE Delivery_ID=?;";
                List<List<String>> r = handler.executeQuery(query, delivery_id);
                for(List<String> strings : r) {
                    res.add(makeDeliveryDetails(strings));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return res.stream()
                    .findFirst();
        }

        return Optional.empty();
    }

    @Override
    public Optional<DeliveryDetails> getDeliveryDetailsByDate(String delivery_date) {
        List<DeliveryDetails> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Delivery_Details WHERE Delivery_Date=?;";
                List<List<String>> r = handler.executeQuery(query, delivery_date);
                for(List<String> strings : r) {
                    res.add(makeDeliveryDetails(strings));
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return res.stream()
                .findFirst();
    }
}
