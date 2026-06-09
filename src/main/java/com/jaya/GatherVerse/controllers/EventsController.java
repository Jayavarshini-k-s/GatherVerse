package com.jaya.GatherVerse.controllers;

import com.jaya.GatherVerse.models.EventModel;
import com.jaya.GatherVerse.models.SearchModel;
import com.jaya.GatherVerse.services.EventsBusinessServiceInterface;
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
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventsBusinessServiceInterface service;

    @GetMapping("/")
    public String showAllEvents(Model model){
        List<EventModel> events = service.getEvents();
        model.addAttribute("title","Events Details");
        model.addAttribute("events",events);
        return"events.html";
    }

    @GetMapping("/showNewEventForm")
    public String showNewForm(Model model){
        model.addAttribute("event", new EventModel());
        return "addNewEventForm.html";
    }

    @PostMapping("/addNew")
    public String addNew(@Valid EventModel newEvent, BindingResult bindingResult, Model model){
        newEvent.setEventId(null);
        service.addOne(newEvent);
        List<EventModel> events = service.getEvents();
        model.addAttribute("events",events);
        return "events";
    }

    @GetMapping("/showSearchForm")
    public String showSearchForm(Model model){
        model.addAttribute("searchModel", new SearchModel());
        return "searchForm.html";
    }

    @PostMapping("/search")
    public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model){
        String searchTerm = searchModel.getSearchTerm();
        List<EventModel> events = service.searchEvents(searchTerm);
        model.addAttribute("events",events);
        return "events";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model){
        List<EventModel> events = service.getEvents();
        model.addAttribute("title","Events Details (Admin)");
        model.addAttribute("events",events);
        return "eventsAdmin.html";
    }

    @PostMapping("/editForm/")
    public String displayEditForm(EventModel eventModel, Model model){
        model.addAttribute("title","Edit event");
        model.addAttribute("eventModel", eventModel);
        return "editForm";
    }

    @PostMapping("/doUpdate")
    public String updateEvent(@Valid EventModel event, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Edit Event");
            model.addAttribute("eventModel", event);
            return "editForm";
        }
        service.updateOne(event.getEventId(), event);
        List<EventModel> events = service.getEvents();
        model.addAttribute("title", "Events Admin");
        model.addAttribute("events", events);
        return "eventsAdmin";
    }

    @PostMapping("/delete/")
    public String deleteEvent(@Valid EventModel event, BindingResult bindingResult, Model model){
        service.deleteOne(event.getEventId());
        List<EventModel> events = service.getEvents();
        model.addAttribute("events",events);
        return "eventsAdmin";
    }

    @GetMapping("/spa")
    public String showSPApage(Model model){
        return "eventsSPA.html";
    }

    @GetMapping("/student")
    public String showStudentPage(Model model){
        List<EventModel> events = service.getEvents();
        model.addAttribute("title","Events Details for Students");
        model.addAttribute("events",events);
        return "studentEvents.html";
    }
}
