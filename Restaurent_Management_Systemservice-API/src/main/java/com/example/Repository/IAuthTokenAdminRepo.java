package com.example.Repository;


import com.example.Entity.AuthenticationTokenAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthTokenAdminRepo extends JpaRepository<AuthenticationTokenAdmin , Integer> {
    AuthenticationTokenAdmin findFirstByTokenValue(String authTokenValue);
}