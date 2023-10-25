package com.example.Service;

import com.example.Entity.FoodItem;
import com.example.Repository.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepo foodItemRepo;
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepo.findAll();
    }

    public String addFoodItem(FoodItem foodItem) {
        foodItemRepo.save(foodItem);
        return "Food item successfully added..";
    }

    public String deleteFoodItem(Integer id) {
        foodItemRepo.deleteById(id);
        return "Food item deleted successfully..";
    }
}