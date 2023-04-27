package com.example.controllers.web;

import com.example.model.Executor;
import com.example.model.WorkType;
import com.example.repository.ExecutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/executor")
@AllArgsConstructor
public class ExecutorController {

    ExecutorRepository repository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addExecutor(@RequestBody Executor executor){
        repository.save(executor);
    }

    @PostMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Executor> getExecutors(){
        return repository.findAll();
    }

    @PostMapping("/addAll")
    @ResponseStatus(HttpStatus.CREATED)
    public void addManyExecutors(@RequestBody List<Executor> executors){
        repository.saveAll(executors);
    }



    @PostMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<Executor> getExecutorByType(@RequestParam("type")WorkType type){
        return repository.findByType(type);
    }
}
