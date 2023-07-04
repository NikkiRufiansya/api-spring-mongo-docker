package com.nikki.apimongodocker.service;

import com.nikki.apimongodocker.model.User;
import com.nikki.apimongodocker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user by ID:  " + id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}