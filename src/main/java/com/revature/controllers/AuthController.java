package com.revature.controllers;

import com.revature.dtos.LoginDTO;
import com.revature.dtos.UserDTO;
import com.revature.services.AuthService;
import com.revature.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService as;
    @Autowired
    public AuthController(AuthService as) {
        System.out.println("Auth Controller was instantiated");
        this.as = as;
    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDTO> authenticate(@RequestBody LoginDTO login) {
        UserDTO user = as.authenticate(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
