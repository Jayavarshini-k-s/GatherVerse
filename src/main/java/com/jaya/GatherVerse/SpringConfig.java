package com.jaya.GatherVerse;

import com.jaya.GatherVerse.data.OrdersDataAccessInterface;
import com.jaya.GatherVerse.data.OrdersDataServiceForRepository;
import com.jaya.GatherVerse.services.OrdersBusinessService;
import com.jaya.GatherVerse.services.OrdersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name="ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        return new OrdersBusinessService();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name="ordersDAO")
    @RequestScope
    public OrdersDataAccessInterface getDataService(){
        return new OrdersDataServiceForRepository(dataSource);
        //return new OrdersDataService();
    }
}
