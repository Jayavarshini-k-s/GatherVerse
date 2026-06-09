package com.jaya.GatherVerse.data;

import com.jaya.GatherVerse.models.EventEntity;
import com.jaya.GatherVerse.models.EventModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class EventsDataServiceForRepository implements EventsDataAccessInterface<EventModel> {

    @Autowired
    EventsRepositoryInterface eventsRepository;

    private JdbcTemplate jdbcTemplate;
    private ModelMapper modelMapper = new ModelMapper();

    public EventsDataServiceForRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public EventModel getById(long id) {
        EventEntity entity = eventsRepository.findById(id).orElse(null);
        if (entity == null) return null;
        return modelMapper.map(entity, EventModel.class);
    }

    @Override
    public List<EventModel> getEvents() {
        Iterable<EventEntity> entities = eventsRepository.findAll();
        List<EventModel> models = new ArrayList<>();
        for (EventEntity item : entities) {
            models.add(modelMapper.map(item, EventModel.class));
        }
        return models;
    }

    @Override
    public List<EventModel> searchEvents(String searchTerm) {
        Iterable<EventEntity> entities = eventsRepository.findByEventNameContainingIgnoreCase(searchTerm);
        List<EventModel> models = new ArrayList<>();
        for (EventEntity entity : entities) {
            models.add(modelMapper.map(entity, EventModel.class));
        }
        return models;
    }

    @Override
    public long addOne(EventModel newEvent) {
        newEvent.setEventId(null);
        try {
            EventEntity entity = modelMapper.map(newEvent, EventEntity.class);
            EventEntity result = eventsRepository.save(entity);
            return result != null ? result.getEventId() : 0;
        } catch (Exception e) {
            System.err.println("Error saving event: " + e.getMessage());
            throw new RuntimeException("Failed to add event", e);
        }
    }

    @Override
    public boolean deleteOne(long id) {
        eventsRepository.deleteById(id);
        return true;
    }

    @Override
    public EventModel updateOne(long idToUpdate, EventModel updateEvent) {
        EventEntity entity = modelMapper.map(updateEvent, EventEntity.class);
        EventEntity result = eventsRepository.save(entity);
        return modelMapper.map(result, EventModel.class);
    }
}
