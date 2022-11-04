package com.revature.controllers;

import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService us;



    @Autowired
    public UserController(UserService us){
        System.out.println("UserController was instantiated");
        this.us = us;
    }


    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(name="role", required = false) Role role){
        List<UserDTO> users = null;

        if (role == null) {
            users = us.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            users = us.getUsersByRole(role);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") String id) {
        UserDTO userDTO = us.getUserById(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterDTO register) {
        UserDTO userDTO = us.registerUser(register);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }
}
