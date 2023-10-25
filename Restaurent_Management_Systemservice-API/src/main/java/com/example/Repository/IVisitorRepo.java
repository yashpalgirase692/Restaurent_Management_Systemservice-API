package com.example.Repository;

import com.example.Entity.VisitorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVisitorRepo extends JpaRepository<VisitorUser , Integer> {

}