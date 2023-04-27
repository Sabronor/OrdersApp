package com.example.repository;

import com.example.model.Executor;
import com.example.model.WorkType;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ExecutorRepository extends CrudRepository<Executor, Long> {
    List<Executor> findAll();
    List<Executor> findByType(WorkType type);
}
