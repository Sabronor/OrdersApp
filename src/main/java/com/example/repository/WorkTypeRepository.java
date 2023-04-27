package com.example.repository;

import com.example.model.WorkType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkTypeRepository extends CrudRepository<WorkType, Long> {
    List<WorkType> findAll();
}
