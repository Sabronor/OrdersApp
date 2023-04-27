package com.example.controllers.web;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    OrderRepository repository;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrder(@RequestBody Order order){
        repository.save(order);
    }

    @PostMapping("/getAllOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAll(){
        return repository.findAll();
    }

    @PostMapping("/getOrders/{page}")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getPageList(@PathVariable("page")int page){
        Pageable pageable = PageRequest.of(page, 10);
        return repository.findAll(pageable);
    }
}
