package com.example.controllers.web;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    CustomerRepository repository;

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer){
        repository.save(customer);
    }

    @PostMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @PostMapping("/addAll")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAllCustomers(@RequestBody List<Customer> customers){
        repository.saveAll(customers);
    }
}
