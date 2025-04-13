package com.sai.spring_sec_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request) {
        return "Hello World " + request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        return "Palli Sai Nithin " + request.getSession().getId();
    }

    @GetMapping("/hi")
    public String hi(HttpServletRequest request) {
        return "Hi this is in hi method (yeah)";
    }

}