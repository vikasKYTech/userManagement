package com.vikas.user.userManagement.services.impl;

import com.vikas.user.userManagement.entities.User;
import com.vikas.user.userManagement.exception.ResourceNotFoundException;
import com.vikas.user.userManagement.repositories.UserRepository;
import com.vikas.user.userManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException("user not found for provided id : "+id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
