package com.example.repository;

import com.example.model.Customer;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
}
