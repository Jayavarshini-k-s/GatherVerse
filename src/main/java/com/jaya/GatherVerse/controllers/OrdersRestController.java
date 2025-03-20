package com.jaya.GatherVerse.controllers;


import com.jaya.GatherVerse.models.OrderModel;
import com.jaya.GatherVerse.services.OrdersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersRestController {

    @Autowired
    OrdersBusinessServiceInterface service;

    //or Alternative
    //remove @Autowired in the top of OrdersBusinessService and do the below steps...

    /*@Autowired
    public OrdersController(OrdersBusinessService service) {
        super();
        this.service = service;
    }*/

    @GetMapping("/")
    public List<OrderModel> showAllOrders(){

        //generate some orders
        List<OrderModel> orders = service.getOrders();

        return orders;
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm){

        //generate some orders
        List<OrderModel> orders = service.searchOrders(searchTerm);

        return orders;
    }

    @PostMapping("/")
    public long addOrder(@RequestBody OrderModel model){
        return service.addOne(model);
    }

    @GetMapping("/{id}")
    public OrderModel getById(@PathVariable(name="id") long id){

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOne(@PathVariable(name="id") long id){

        return service.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public OrderModel update(@RequestBody OrderModel model, @PathVariable(name="id") long id){

        return service.updateOne(id,model);
    }
}
