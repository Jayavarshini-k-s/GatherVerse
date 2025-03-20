package com.jaya.GatherVerse.services;

import com.jaya.GatherVerse.data.OrdersDataAccessInterface;
import com.jaya.GatherVerse.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    @Qualifier("ordersDAO")
    OrdersDataAccessInterface<OrderModel> ordersDAO;

    public static class OrderServiceException extends RuntimeException {
        public OrderServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    @Override
    public void test() {

        System.out.println("OrderBusinessService is working");
    }

    @Override
    public OrderModel getById(long id) {

        return ordersDAO.getById(id);
    }

    @Override
    public List<OrderModel> getOrders() {

        return ordersDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel newOrder) {
        //return ordersDAO.addOne(newOrder);

        try {
            return ordersDAO.addOne(newOrder);
        } catch (Exception e) {
            System.err.println("Error adding order: " + e.getMessage());
            throw new OrderServiceException("Failed to add order", e);
        }

    }

    @Override
    public boolean deleteOne(long id) {
        return ordersDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        return ordersDAO.updateOne(idToUpdate,updateOrder);
    }

    @Override
    public void init() {
        System.out.println("Init method of the orders business service 2");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the order business service 2");
    }
}
