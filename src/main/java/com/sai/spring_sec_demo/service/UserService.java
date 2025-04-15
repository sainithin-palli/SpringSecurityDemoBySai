package com.sai.spring_sec_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.spring_sec_demo.dao.UserRepo;
import com.sai.spring_sec_demo.model.User;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user) {
        return repo.save(user);
    }
}
