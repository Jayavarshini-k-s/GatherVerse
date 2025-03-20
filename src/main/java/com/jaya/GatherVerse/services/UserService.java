package com.jaya.GatherVerse.services;

import com.jaya.GatherVerse.data.UserRepository;
import com.jaya.GatherVerse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByUsernameAndRole(String username,String role) {
        return userRepository.findByUsernameAndRole(username,role);
    }
    public void registerUser(User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        // Save the new user to the database
        userRepository.save(user);
    }

    // Validate user credentials
    public boolean validateUserCredentials(String username, String password, String role) {
        User user = findUserByUsernameAndRole(username, role);
        return user != null && user.getPassword().equals(password); // Simple password check
    }

}

