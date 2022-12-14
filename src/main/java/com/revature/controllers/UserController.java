package com.revature.controllers;

import com.revature.annotations.RoleFilter;
import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.Movie;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.entities.UserMovie;
import com.revature.services.MovieService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private UserService us;
    private MovieService ms;

    @Autowired
    public UserController(UserService us, MovieService ms){
        System.out.println("UserController was instantiated");
        this.us = us;
        this.ms = ms;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(name="role", required = false) Role role){
        List<UserDTO> users = null;
        System.out.println(users);
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

    @GetMapping("uname/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username){
        UserDTO userDTO = us.getUserByUsername(username);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
// Register currently broken because of ID assignment issues.
    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterDTO register) {
        UserDTO userDTO = us.registerUser(register);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/watched")
    public ResponseEntity<List<Movie>> getMoviesByUserId(@PathVariable("id") String id){
        List<Movie> watchedList = ms.getWatchedMoviesByUserId(id);
        return new ResponseEntity<>(watchedList, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json", value = "/{id}/watched")
    public ResponseEntity<Boolean> toggleMovieByUserId(@PathVariable("id") String id, @RequestBody Movie movie){
        Boolean toggleMovie = ms.toggleWatchedMovieByUserId(id, movie);
        return new ResponseEntity<>(toggleMovie, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json", value = "/{id}/movies")
    public ResponseEntity<Boolean> checkIfUserWatchedMovie(@PathVariable("id") String id, @RequestBody Movie movie){
        Boolean watchedMovie = ms.checkIfUserWatchedMovie(id, movie);
        return new ResponseEntity<>(watchedMovie, HttpStatus.OK);
    }

    //Function to change user's role ( implementation not final )
    @CrossOrigin
    @RoleFilter(rolesAllowed = {"HEN", "ROOSTER"})
    @PutMapping
    public ResponseEntity<UserDTO> changeUserRole(@RequestBody UserDTO user) {
        UserDTO updatedUser = us.updateRole(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
