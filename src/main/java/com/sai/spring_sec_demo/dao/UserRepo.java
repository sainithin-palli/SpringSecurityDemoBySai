package com.sai.spring_sec_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.spring_sec_demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}