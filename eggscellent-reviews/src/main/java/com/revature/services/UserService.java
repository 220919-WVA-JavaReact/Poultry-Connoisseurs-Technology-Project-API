package com.revature.services;

import com.revature.dtos.UserDTO;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

}
