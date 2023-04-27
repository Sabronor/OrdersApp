package com.example.repository;

import com.example.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAll();
    List<Order> findAll(Pageable pageable);
}
