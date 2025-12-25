package com.vikas.user.userManagement.services;

import com.vikas.user.userManagement.entities.User;

import java.util.List;

public interface UserService {

    // Save user
    User saveUser(User user);

    User getUser(int id);

    List<User> getAllUsers();

}
