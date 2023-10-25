package com.example.Controller;

import com.example.Entity.FoodItem;
import com.example.Entity.VisitorUser;
import com.example.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {
    @Autowired
    VisitorService visitorService;

    @PostMapping("visitor")
    public String addVisitor(@RequestBody VisitorUser visitor){
        return visitorService.addVisitor(visitor);
    }


    @GetMapping("foodItems/visitor")
    public List<FoodItem> getAllFoodItems(){
        return visitorService.getAllFoodItems();
    }
}