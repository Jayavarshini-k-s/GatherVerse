package com.jaya.GatherVerse.data;

import com.jaya.GatherVerse.models.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity,Long> {
    //use the CrudRepository class in Spring to do the data operations on mysql
    //already implies that we will use save, findall, findbyid, deletebyid etc.

    List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);

}
