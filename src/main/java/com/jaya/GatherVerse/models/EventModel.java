package com.jaya.GatherVerse.models;

public class EventModel {

    private Long eventId;
    private String eventName = "";
    private String description = "";
    private String eventDate = "";
    private String venue = "";
    private Integer seats = 0;
    private float fee = 0.0f;

    public EventModel() {
    }

    public EventModel(Long eventId, String eventName, String description, String eventDate, String venue, Integer seats, float fee) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.eventDate = eventDate;
        this.venue = venue;
        this.seats = seats;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", description='" + description + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", venue='" + venue + '\'' +
                ", seats=" + seats +
                ", fee=" + fee +
                '}';
    }

    // Getters and Setters
    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEventDate() { return eventDate; }
    public void setEventDate(String eventDate) { this.eventDate = eventDate; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public Integer getSeats() { return seats; }
    public void setSeats(Integer seats) { this.seats = seats; }

    public float getFee() { return fee; }
    public void setFee(float fee) { this.fee = fee; }
}
