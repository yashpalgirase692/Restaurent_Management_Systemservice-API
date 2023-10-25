package com.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String name;
    //    @Pattern(regexp = "^[^@\\s]+@Admin\\.com$\n")  // The admin email should always end @Admin.com
    @Email
    private String email;
    private String password;
    @Pattern(regexp = "^\\d{10}$") // Mobile no should contain 10 digits only
    private String mobileNumber;
}