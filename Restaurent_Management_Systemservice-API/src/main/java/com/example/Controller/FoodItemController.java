package com.example.Controller;

import com.example.Entity.FoodItem;
import com.example.Service.AuthTokenAdminService;
import com.example.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;

    @Autowired
    AuthTokenAdminService authTokenAdminService;

    @PostMapping("foodItem")
    public String addFoodItem(@RequestBody FoodItem foodItem , @RequestParam String email , @RequestParam String token){
        if(authTokenAdminService.authenticateAdmin(email , token )) {
            return foodItemService.addFoodItem(foodItem);
        }
        return "Only admin can add food item...";
    }

    @DeleteMapping("foodItem")
    public String deleteFoodItem(@RequestParam Integer id , @RequestParam String email , @RequestParam String token){
        if(authTokenAdminService.authenticateAdmin(email , token )) {
            return foodItemService.deleteFoodItem(id);
        }
        return "Only admin can delete food item...";
    }
}