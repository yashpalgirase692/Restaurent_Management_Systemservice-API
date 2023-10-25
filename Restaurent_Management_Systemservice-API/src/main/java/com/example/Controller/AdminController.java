package com.example.Controller;

import com.example.Entity.Admin;
import com.example.Entity.User;
import com.example.Service.AdminService;
import com.example.Service.AuthTokenAdminService;
import com.example.Service.OrderService;
import com.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    AuthTokenAdminService authTokenAdminService;

    @PostMapping("admin/signUp")
    public String signUpAdmin(@RequestBody Admin admin){
        return adminService.signUpAdmin(admin);
    }

    @PostMapping("admin/signIn")
    public String signInAdmin(@RequestParam String adminEmail , String password ){
        return adminService.signInAdmin(adminEmail , password);
    }

    @GetMapping("users")
    public List<User> getListOfUsers(@RequestParam String email , @RequestParam String token){
        if(authTokenAdminService.authenticateAdmin(email , token)) {
            return userService.getListOfUsers();
        }
        return null;
    }

}