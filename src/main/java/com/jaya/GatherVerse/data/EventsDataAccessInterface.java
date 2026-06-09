package com.jaya.GatherVerse.data;

import java.util.List;

public interface EventsDataAccessInterface<T> {

    public T getById(long id);
    public List<T> getEvents();
    public List<T> searchEvents(String searchTerm);
    public long addOne(T newEvent);
    public boolean deleteOne(long id);
    public T updateOne(long idToUpdate, T updateEvent);
}
