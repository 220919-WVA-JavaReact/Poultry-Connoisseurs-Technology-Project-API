package com.revature.controllers;

import com.revature.dtos.UserDTO;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping
//    public R
    // localhost8080/users/{username} => above function
}
