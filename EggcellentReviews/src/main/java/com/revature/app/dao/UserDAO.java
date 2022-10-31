package com.revature.app.dao;

import com.revature.app.models.User;

public interface UserDAO {

    User getByUsername(String username);

    User createUser(String first, String last, String username,
                        String password, Boolean manager);

}
