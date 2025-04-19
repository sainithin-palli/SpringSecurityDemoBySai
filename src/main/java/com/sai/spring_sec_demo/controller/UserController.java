package com.sai.spring_sec_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sai.spring_sec_demo.model.User;
import com.sai.spring_sec_demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // number of rounds we have to go with 12

    @PostMapping("register")

    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("The new Hased Password is: "+user.getPassword());
        return userService.saveUser(user);
    }

}
