package com.example.Controller;

import com.example.Entity.Order;
import com.example.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("order")
    public Optional<Order> getOrderById(@RequestParam Integer orderId){
        return orderService.getOrderById(orderId);
    }


}