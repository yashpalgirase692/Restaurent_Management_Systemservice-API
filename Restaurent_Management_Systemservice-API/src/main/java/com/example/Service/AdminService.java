package com.example.Service;

import com.example.Entity.*;
import com.example.Entity.Admin;
import com.example.Repository.IAdminRepo;
import com.example.Service.Utility.EmailHandler;
import com.example.Service.Utility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    AuthTokenAdminService authTokenAdminService;

    public String signUpAdmin(Admin admin) {

        String newEmail = admin.getEmail();

        if(newEmail == null)
        {
            return "Invalid email";

        }

        // check if Admin already exists means already signUp

        Admin existingAdmin = adminRepo.findFirstByEmail(newEmail);

        if(existingAdmin != null)
        {
            return  "Admin email already registered.";

        }

        // If it cant able to return anything means it is new Admin, so we need save the Admin
        // By hashing the password: encrypt the password to security purpose
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getPassword());


            admin.setPassword(encryptedPassword);
            adminRepo.save(admin);

            return "Admin registered successfully!!!";
        }
        catch(Exception e)
        {
            return "Internal error occurred during sign up..Please try again later..";

        }
    }


    public String signInAdmin(String adminEmail, String password) {
        if(adminEmail == null)
        {
            return "Invalid email";

        }

        //check if Admin is exists or not
        Admin existingAdmin = adminRepo.findFirstByEmail(adminEmail);

        if(existingAdmin == null)
        {
            return  "Email not registered!!!";
        }

        // if we cant able to return then it means Admin exist so need to verify and create session for Admin

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(password);

            if(existingAdmin.getPassword().equals(encryptedPassword))
            {

                AuthenticationTokenAdmin authTokenAdmin  = new AuthenticationTokenAdmin(existingAdmin);
                authTokenAdminService.save(authTokenAdmin);

                EmailHandler.sendEmail(adminEmail,"Authentication token received via signing in",authTokenAdmin.getTokenValue());
                return "Token sent to your registered email";
            }
            else {
                return "Invalid credentials!!!";
            }
        }
        catch(Exception e)
        {
            return  "Internal error occurred during sign in";
        }

    }
}