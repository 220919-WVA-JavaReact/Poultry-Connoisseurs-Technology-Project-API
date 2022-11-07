package com.revature.services;

import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserDTO;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.RegisterException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository ur;

    @Autowired
    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public UserDTO getUserById(String id) {
        User user = ur.findById(id).orElseThrow(() -> new UserNotFoundException());
        UserDTO userDTO = new UserDTO(user);

        return userDTO;
        //response entity
    }

    public UserDTO getUserByUsername(String username) throws UserNotFoundException {
        User user = ur.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException());
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = ur.findAll();
        List<UserDTO> userDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return userDTO;
    }

    public List<UserDTO> getUsersByRole(Role role) {
        List<User> users = ur.findUsersByRole(role);
        List<UserDTO> userDTO = users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return userDTO;
    }

    public UserDTO registerUser(RegisterDTO register) {
        //check if username from register instance exists
        if (ur.findUserByUsername(register.getUsername()).isPresent()){
            throw new RegisterException();
        }

        User newUser = new User();
        newUser.setFirst(register.getFirstName());
        newUser.setLast(register.getLastName());
        newUser.setUsername(register.getUsername());
        newUser.setPassword(register.getPassword());
        newUser.setRole(Role.EGG);

        // .save saves into the database
        return new UserDTO(ur.save(newUser));
    }
}
