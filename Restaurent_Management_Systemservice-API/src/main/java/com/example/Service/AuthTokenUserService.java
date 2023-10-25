package com.example.Service;

import com.example.Entity.AuthenticationToken;
import com.example.Entity.User;
import com.example.Repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenUserService {
    @Autowired
    IAuthTokenRepo authTokenRepo;



    public void save(AuthenticationToken authToken) {
        authTokenRepo.save(authToken);
    }



    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authTokenRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getEmail();

        return tokenConnectedEmail.equals(email); // if equals then true else false.
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authTokenRepo.findFirstByUser(user);
    }

    public void delete(AuthenticationToken authenticationToken) {
        authTokenRepo.delete(authenticationToken);
    }

}