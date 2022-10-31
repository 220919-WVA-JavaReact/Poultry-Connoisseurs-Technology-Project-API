package com.revature.app.service;

import com.revature.app.dao.UserDAO;
import com.revature.app.dao.UserDAOimpl;
import com.revature.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    @Autowired

    UserDAO ud = new UserDAOimpl();

    public User login(String username, String password){
        User result = ud.getByUsername(username);
            if ((result != null) && (result.getPassword().equals(password))){
                return result;
            }
        return null;
    }

    public User register(String first,String last,String username,String password,Boolean manager){
        User result = ud.createUser(first, last, username, password, manager);
        return result;
    }


}
