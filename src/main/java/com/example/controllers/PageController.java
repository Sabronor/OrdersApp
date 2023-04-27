package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PageController {

    @GetMapping("/index")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/order")
    public String orderPage(){
        return "order";
    }

    @GetMapping("/customer")
    public String customerPage(){
        return "customer";
    }

    @GetMapping("/executor")
    public String executorPage(){
        return "executor";
    }

    @GetMapping("/allOrders")
    public String allOrdersPage(){
        return "orders";
    }
}
