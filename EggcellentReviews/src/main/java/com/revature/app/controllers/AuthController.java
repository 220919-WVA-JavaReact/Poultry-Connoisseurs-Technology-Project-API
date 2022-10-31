package com.revature.app.controllers;

import com.revature.app.models.User;
import com.revature.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService as;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody Credentials creds){

        try
        User principal = as.login(creds.getUsername(), creds.getPassword())
        return ResponseEntity.ok(principal);

        catch block
                return ResponseEntity.badRequest().build()


    }
    @GetMapping("/${id}")
    public ResponseEntity getById(@PathVariable int id){
        return "dn";
    }
}
