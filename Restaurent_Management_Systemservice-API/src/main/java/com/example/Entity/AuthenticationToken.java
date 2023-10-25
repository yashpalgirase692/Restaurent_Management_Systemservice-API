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
public class AuthenticationToken{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    // as one token will be associated with one user only
    @OneToOne
    @JoinColumn(name = "fk_user_Id")
    User user;


    // Created parameterized constructor with user only because other things we are assigning manually..
    public AuthenticationToken(User user)
    {
        this.user = user;
        this.tokenValue = UUID.randomUUID().toString();  // to generate some unique string(token)
        this.tokenCreationDateTime = LocalDateTime.now();
    }
}