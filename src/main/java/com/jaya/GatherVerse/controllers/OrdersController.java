package com.jaya.GatherVerse.controllers;


import com.jaya.GatherVerse.models.OrderModel;
import com.jaya.GatherVerse.models.SearchModel;
import com.jaya.GatherVerse.services.OrdersBusinessServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

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
    public String showAllOrders(Model model){

        //generate some orders
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title","Event Details");
        model.addAttribute("orders",orders);

        return"orders.html";
    }


    @GetMapping("/showNewOrderForm")
    public String showNewForm(Model model){

        model.addAttribute("order", new OrderModel());
        return "addNewOrderForm.html";
    }

    @PostMapping("/addNew")
    public String addNew(@Valid OrderModel newOrder, BindingResult bindingResult, Model model){
        //processing here
        newOrder.setId(null);
        //add to the database
        service.addOne(newOrder);
        //get all orders from the database
        List<OrderModel> orders = service.getOrders();
        //show all orders page
        model.addAttribute("orders",orders);

        return "orders";
    }

    @GetMapping("/showSearchForm")
    public String showSearchForm(Model model){

        model.addAttribute("searchModel", new SearchModel());
        return "searchForm.html";
    }

    @PostMapping("/search")
    public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model){

        String searchTerm = searchModel.getSearchTerm();
        List<OrderModel> orders = service.searchOrders(searchTerm);
        //show all orders page
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model){

        //generate some orders
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title","Events Details");
        model.addAttribute("orders",orders);

        return"ordersAdmin.html";
    }

    @PostMapping("/editForm/")
    public String displayEditForm(OrderModel orderModel,Model model){
        model.addAttribute("title","Edit order");
        model.addAttribute("orderModel", orderModel);
        return "editForm";
    }

    @PostMapping("/doUpdate")
    //process a request from the AddOrderForm. Add a new order to the database.Show all orders.
    public String updateOrder(@Valid OrderModel order,BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            // If there are validation errors, go back to the edit form with the errors
            model.addAttribute("title", "Edit Order");
            model.addAttribute("orderModel", order); // Pass the original order model back
            return "editForm"; // Reload the edit form with error messages
        }

        // Proceed with update if there are no validation errors
        service.updateOne(order.getId(), order);

        // Get updated list of all orders
        List<OrderModel> orders = service.getOrders();

        // Set up model attributes for ordersAdmin view
        model.addAttribute("title", "Orders Admin");
        model.addAttribute("orders", orders);

        return "ordersAdmin";
    }

    @PostMapping("/delete/")
    public String deleteOrder(@Valid OrderModel order, BindingResult bindingResult, Model model){
        service.deleteOne(order.getId());
        //get updated list of all the orders
        List<OrderModel> orders = service.getOrders();

        //display all orders
        model.addAttribute("orders",orders);
        return "ordersAdmin";
    }

    @GetMapping("/spa")
    public String showSPApage(Model model){
        return "ordersSPA.html";
    }

    @GetMapping("/student")
    public String showStudentPage(Model model){

        //generate some orders
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title","Events details for Elites");
        model.addAttribute("orders",orders);

        return"StudentOrders.html";
    }
}
