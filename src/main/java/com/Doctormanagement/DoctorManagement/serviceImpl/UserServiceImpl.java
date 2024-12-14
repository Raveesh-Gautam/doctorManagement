package com.Doctormanagement.DoctorManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Doctormanagement.DoctorManagement.model.User;
import com.Doctormanagement.DoctorManagement.repository.UserRepository;
import com.Doctormanagement.DoctorManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> registerUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists.");
        }
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sign up successfully");
    }

    @Override
    public ResponseEntity<String> loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
