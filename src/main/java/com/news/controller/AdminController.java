package com.news.controller;

import com.news.model.Admin;
import com.news.model.res.RespUser;
import com.news.model.User;
import com.news.model.req.Uid;
import com.news.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public RespUser login(@RequestBody Admin admin){
        return adminService.findUser(admin);
    }

    @PostMapping("/register")
    public RespUser register(@RequestBody Admin admin){
        return adminService.saveUser(admin);
    }

    @PostMapping("/index")
    public User index(@RequestBody Uid uid){
        return adminService.findUserById(uid.getUid());
    }

}
