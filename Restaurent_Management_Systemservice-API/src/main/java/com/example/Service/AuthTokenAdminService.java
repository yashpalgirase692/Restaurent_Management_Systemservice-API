package com.example.Service;


import com.example.Entity.AuthenticationTokenAdmin;
import com.example.Repository.IAuthTokenAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenAdminService {

    @Autowired
    IAuthTokenAdminRepo authTokenAdminRepo;

    public boolean authenticateAdmin(String email, String authTokenValue)
    {
        AuthenticationTokenAdmin authToken = authTokenAdminRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getAdmin().getEmail();

        return tokenConnectedEmail.equals(email); // if equals then true else false.
    }

    public void save(AuthenticationTokenAdmin authTokenAdmin) {
        authTokenAdminRepo.save(authTokenAdmin);
    }
}