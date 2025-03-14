package com.adeleke.flyroamer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adeleke.flyroamer.model.User;
import com.adeleke.flyroamer.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        // Check if email already exists
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Method to authenticate user login
    public Optional<User> loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password)); // Simple validation
    }
}

