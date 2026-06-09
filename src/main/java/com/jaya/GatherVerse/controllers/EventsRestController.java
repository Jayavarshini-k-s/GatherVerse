package com.jaya.GatherVerse.controllers;

import com.jaya.GatherVerse.models.EventModel;
import com.jaya.GatherVerse.services.EventsBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventsRestController {

    @Autowired
    EventsBusinessServiceInterface service;

    @GetMapping("/")
    public List<EventModel> showAllEvents() {
        return service.getEvents();
    }

    @GetMapping("/search/{searchTerm}")
    public List<EventModel> searchEvents(@PathVariable(name="searchTerm") String searchTerm) {
        return service.searchEvents(searchTerm);
    }

    @PostMapping("/")
    public long addEvent(@RequestBody EventModel model) {
        return service.addOne(model);
    }

    @GetMapping("/{id}")
    public EventModel getEvent(@PathVariable(name="id") long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable(name="id") long id) {
        return service.deleteOne(id);
    }

    @PutMapping("/{id}")
    public EventModel updateEvent(@RequestBody EventModel model, @PathVariable(name="id") long id) {
        return service.updateOne(id, model);
    }
}
