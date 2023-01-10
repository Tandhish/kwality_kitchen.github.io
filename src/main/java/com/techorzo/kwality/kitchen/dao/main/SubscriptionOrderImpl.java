package com.techorzo.kwality.kitchen.dao.main;

import com.techorzo.kwality.kitchen.misc.SqlHandler;
import com.techorzo.kwality.kitchen.model.main.SubscriptionOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("SqlLite")
public class SubscriptionOrderImpl implements SubscriptionOrderDao{
    private final SqlHandler handler;

    public SubscriptionOrderImpl() { handler = SqlHandler.getInstance(); }

    @Override
    public int insertSubscriptionOrder(String transaction_id, SubscriptionOrder subscriptionOrder) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "INSERT INTO Subscription_Order (Customer_ID, Product_ID, Subscription_Order_Date, Subscription_Order_Status, Transaction_ID) values (?,?,?,?,?);";
                res = handler.executeUpdate(query, subscriptionOrder.getCustomerID(), subscriptionOrder.getCustomerID(), subscriptionOrder.getSubscriptionOrderDate(), subscriptionOrder.getSubscriptionOrderStatus(), transaction_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int deleteSubscriptionOrder(String transaction_id) {
        int res = -1;

        if(handler.isConnectedDB()) {
            try {
                String query = "DELETE FROM Subscription_Order WHERE Transaction_ID=?;";
                res = handler.executeUpdate(query, transaction_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public Optional<SubscriptionOrder> getSubscriptionOrderByID(String transaction_id) {
        List<SubscriptionOrder> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Subscription_Order WHERE Transaction_ID=?;";
                List<List<String>> r = handler.executeQuery(query, transaction_id);
                for(List<String> strings : r) {
                    res.add(makeSubscriptionOrder(strings));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }

    @Override
    public Optional<SubscriptionOrder> getSubscriptionOrderByDate(String date) {
        List<SubscriptionOrder> res = new ArrayList<>();

        if(handler.isConnectedDB()) {
            try {
                String query = "SELECT * FROM Subscription_Order WHERE Subscription_Order_Date=?;";
                List<List<String>> r = handler.executeQuery(query, date);
                for(List<String> strings : r) {
                    res.add(makeSubscriptionOrder(strings));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res.stream()
                .findFirst();
    }
}
