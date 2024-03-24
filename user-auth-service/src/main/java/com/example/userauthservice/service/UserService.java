package com.example.userauthservice.service;

import java.util.Optional;
import com.example.userauthservice.entity.User;
import com.example.userauthservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setHashedPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public boolean loginUser(String username, String password) {
        // Use the `Optional` to check if user exists and then match password
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return passwordEncoder.matches(password, user.getHashedPassword());
        }
        return false; // User not found
    }
}
