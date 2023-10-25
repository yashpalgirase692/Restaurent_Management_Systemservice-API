package com.example.Repository;

import com.example.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Integer> {

    Admin findFirstByEmail(String newEmail);
}