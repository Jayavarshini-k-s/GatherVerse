package com.jaya.GatherVerse.services;

import com.jaya.GatherVerse.models.EventModel;
import java.util.List;

public interface EventsBusinessServiceInterface {
    public void test();
    public void init();
    public void destroy();
    public EventModel getById(long id);
    public List<EventModel> getEvents();
    public List<EventModel> searchEvents(String searchTerm);
    public long addOne(EventModel newEvent);
    public boolean deleteOne(long id);
    public EventModel updateOne(long idToUpdate, EventModel updateEvent);
}
