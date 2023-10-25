package com.example.Service;

import com.example.Entity.FoodItem;
import com.example.Entity.VisitorUser;
import com.example.Repository.IVisitorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VisitorService {

    @Autowired
    IVisitorRepo visitorRepo;
    @Autowired
    FoodItemService foodItemService;


    public String addVisitor(VisitorUser visitor) {
        visitorRepo.save(visitor);
        return "visitor details saved successfully..";
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }


}