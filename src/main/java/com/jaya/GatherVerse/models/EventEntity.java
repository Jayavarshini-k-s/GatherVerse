package com.jaya.GatherVerse.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("events")
public class EventEntity {

    @Id
    @Column("event_id")
    private Long eventId;

    @Column("event_name")
    private String eventName;

    @Column("description")
    private String description;

    @Column("event_date")
    private String eventDate;

    @Column("venue")
    private String venue;

    @Column("seats")
    private Integer seats;

    @Column("fee")
    private float fee;

    public EventEntity() {
    }

    public EventEntity(Long eventId, String eventName, String description, String eventDate, String venue, Integer seats, float fee) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.eventDate = eventDate;
        this.venue = venue;
        this.seats = seats;
        this.fee = fee;
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
