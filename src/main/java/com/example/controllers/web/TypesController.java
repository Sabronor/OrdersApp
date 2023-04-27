package com.example.controllers.web;

import com.example.model.WorkType;
import com.example.repository.WorkTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/types")
@AllArgsConstructor
public class TypesController {

    WorkTypeRepository repository;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WorkType> getTypes(){
        return repository.findAll();
    }
}
