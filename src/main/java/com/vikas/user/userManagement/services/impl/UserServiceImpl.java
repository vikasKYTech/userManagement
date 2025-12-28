package com.vikas.user.userManagement.services.impl;

import com.vikas.user.userManagement.entities.Rating;
import com.vikas.user.userManagement.entities.User;
import com.vikas.user.userManagement.exception.ResourceNotFoundException;
import com.vikas.user.userManagement.repositories.UserRepository;
import com.vikas.user.userManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;
    public RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RestTemplate restTemplate){
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new ResourceNotFoundException("user not found for provided id : "+id));
//        List<Rating> ratingList = restTemplate.getForObject("http://localhost:9092/rating/byUser/"+user.getId(), ArrayList.class);
        List<Rating> ratingList = restTemplate.getForObject("http://RATING-SERVICE/rating/byUser/"+user.getId(), ArrayList.class);
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
