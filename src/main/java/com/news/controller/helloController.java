package com.news.controller;

import com.news.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @PostMapping("User")
    public User world(@RequestBody User user){
        return user;
    }
}
