package com.jaya.GatherVerse.data;

import com.jaya.GatherVerse.models.EventEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EventsRepositoryInterface extends CrudRepository<EventEntity, Long> {
    List<EventEntity> findByEventNameContainingIgnoreCase(String searchTerm);
}
