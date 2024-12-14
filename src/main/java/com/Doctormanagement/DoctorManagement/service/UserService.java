package com.Doctormanagement.DoctorManagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Doctormanagement.DoctorManagement.model.User;

@Service
public interface UserService {
    ResponseEntity<String> registerUser(User user);
    ResponseEntity<String> loginUser(String email, String password);
    User getUserById(Long userId);
}
