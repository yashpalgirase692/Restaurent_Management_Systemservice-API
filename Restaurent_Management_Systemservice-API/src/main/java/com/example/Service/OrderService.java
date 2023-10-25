package com.example.Service;

import com.example.Entity.Order;
import com.example.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    public String orderFoodItem(Order order) {
        order.setOrderDateTime(LocalDateTime.now());
        order.setStatus("Your order is placed successfully..");
        orderRepo.save(order);
        return "Order successfully placed";
    }


    public Optional<Order> getOrderById(Integer orderId) {
        return orderRepo.findById(orderId);
    }

    public List<Order> getListOfOrders() {
        return orderRepo.findAll();
    }

    public String cancelOrder(Integer id) {
        orderRepo.deleteById(id);
        return "Order cancel successfully...";
    }
}