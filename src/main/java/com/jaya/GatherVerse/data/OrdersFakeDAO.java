package com.jaya.GatherVerse.data;

import com.jaya.GatherVerse.models.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface<OrderModel>{

    List<OrderModel> orders = new ArrayList<>();



    public OrdersFakeDAO() {

        /*orders.add(new OrderModel(0L,"AAA","Big Mac",3.0f,8));
        orders.add(new OrderModel(1L,"AAB","Large Fries",15.0f,5));
        orders.add(new OrderModel(2L,"AAC","Chicker Fries",14.3f,1));
        orders.add(new OrderModel(3L,"AAD","Apple pie",56.0f,20));*/

    }

    @Override
    public OrderModel getById(long id) {

        for(int i=0; i<orders.size(); i++){
            if(orders.get(i).getId()==id){
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {

        List<OrderModel> foundItems = new ArrayList<>();
        for(int i=0; i< orders.size(); i++){
            if(orders.get(i).getProductName().toLowerCase().contains(searchTerm))
                foundItems.add(orders.get(i));
        }
        return foundItems;
    }

    @Override
    public long addOne(OrderModel newOrder) {
        boolean success = orders.add(newOrder);

        if(success){
            return 1;
        }
        else
            return 0;
    }

    @Override
    public boolean deleteOne(long id) {

        for(int i=0; i<orders.size();i++){
            if(orders.get(i).getId()==id){
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        for(int i=0; i<orders.size();i++){
            if(orders.get(i).getId()==idToUpdate){
                orders.set(i,updateOrder);
                return orders.get(i);
            }
        }
        return null;
    }
}
