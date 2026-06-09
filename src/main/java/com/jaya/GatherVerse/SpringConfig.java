package com.jaya.GatherVerse;

import com.jaya.GatherVerse.data.EventsDataAccessInterface;
import com.jaya.GatherVerse.data.EventsDataServiceForRepository;
import com.jaya.GatherVerse.services.EventsBusinessService;
import com.jaya.GatherVerse.services.EventsBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name="eventsBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public EventsBusinessServiceInterface getEventsBusiness(){
        return new EventsBusinessService();
    }

    @Autowired
    DataSource dataSource;

    @Bean(name="eventsDAO")
    @RequestScope
    public EventsDataAccessInterface getEventsDataService(){
        return new EventsDataServiceForRepository(dataSource);
    }
}
