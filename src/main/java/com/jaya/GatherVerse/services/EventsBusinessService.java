package com.jaya.GatherVerse.services;

import com.jaya.GatherVerse.data.EventsDataAccessInterface;
import com.jaya.GatherVerse.models.EventModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventsBusinessService implements EventsBusinessServiceInterface {

    @Autowired
    EventsDataAccessInterface<EventModel> eventsDAO;

    @Override
    public void test() {
        System.out.println("EventsBusinessService is working");
    }

    @Override
    public void init() {
        System.out.println("Init method of EventsBusinessService");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of EventsBusinessService");
    }

    @Override
    public EventModel getById(long id) {
        return eventsDAO.getById(id);
    }

    @Override
    public List<EventModel> getEvents() {
        return eventsDAO.getEvents();
    }

    @Override
    public List<EventModel> searchEvents(String searchTerm) {
        return eventsDAO.searchEvents(searchTerm);
    }

    @Override
    public long addOne(EventModel newEvent) {
        return eventsDAO.addOne(newEvent);
    }

    @Override
    public boolean deleteOne(long id) {
        return eventsDAO.deleteOne(id);
    }

    @Override
    public EventModel updateOne(long idToUpdate, EventModel updateEvent) {
        return eventsDAO.updateOne(idToUpdate, updateEvent);
    }
}
