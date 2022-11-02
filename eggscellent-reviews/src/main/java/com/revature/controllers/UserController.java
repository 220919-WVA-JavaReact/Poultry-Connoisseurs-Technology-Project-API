package com.revature.controllers;

import com.revature.dtos.UserDTO;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
        UserDTO userDTO = us.getUserById(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);

    }
    // localhost8080/users/{username} => above function
}
