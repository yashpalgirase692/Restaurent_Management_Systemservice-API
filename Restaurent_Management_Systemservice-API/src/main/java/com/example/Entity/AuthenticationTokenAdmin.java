package com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationTokenAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    // as one token will be associated with one Admin only
    @OneToOne
    @JoinColumn(name = "fk_admin_Id")
    Admin admin;


    // Created parameterized constructor with Admin only because other things we are assigning manually..
    public AuthenticationTokenAdmin(Admin admin)
    {
        this.admin = admin;
        this.tokenValue = UUID.randomUUID().toString();  // to generate some unique string(token)
        this.tokenCreationDateTime = LocalDateTime.now();
    }
}