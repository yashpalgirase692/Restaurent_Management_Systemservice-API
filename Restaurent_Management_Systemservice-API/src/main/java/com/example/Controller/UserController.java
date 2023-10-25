package com.example.Controller;

import com.example.Entity.FoodItem;
import com.example.Entity.Order;
import com.example.Entity.User;
import com.example.Service.AuthTokenUserService;
import com.example.Service.FoodItemService;
import com.example.Service.OrderService;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthTokenUserService authTokenUserService;

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    OrderService orderService;

    @PostMapping("user/signUp")
    public String signUpUser(@RequestBody User user){
        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String signInUser(@RequestParam String userEmail , String password ){
        return userService.signInUser(userEmail , password);
    }

    @DeleteMapping("user/signOut")
    public String signOut(@RequestParam String email , String authToken){
        if(authTokenUserService.authenticate(email , authToken)){
            return userService.signOut(email);
        }else{
            return "You are not valid user sign in first";
        }
    }

    @GetMapping("foodItems")
    public List<FoodItem> getListOfFoodItems(@RequestParam String email , @RequestParam String authToken){
        if(authTokenUserService.authenticate(email , authToken)){
            return foodItemService.getAllFoodItems();
        }
        return null;
    }

    @PostMapping("order/foodItem")
    public String orderFoodItem(@RequestBody Order order , @RequestParam String email , @RequestParam String authToken){
        if(authTokenUserService.authenticate(email , authToken)) {
            return orderService.orderFoodItem(order);
        }
        return "Not a authenticated user sign up to order food item";
    }

    @DeleteMapping("order")
    public String cancelOrder(@RequestParam Integer id , @RequestParam String email , @RequestParam String authToken){
        if(authTokenUserService.authenticate(email , authToken)) {
            return orderService.cancelOrder(id);
        }
        return "Not authenticated user";
    }


}