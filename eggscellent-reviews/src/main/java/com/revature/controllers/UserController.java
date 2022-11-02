package com.revature.controllers;

import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService us;

    @Autowired
    public UserController(UserService us){
        System.out.println("UserController was instantiated");
        this.us = us;
    }
}
