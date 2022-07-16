package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findFirstByEmail(String email);
    User findFirstByEmailAndPassword(String email , String pass);
    User findById(int id);
}
