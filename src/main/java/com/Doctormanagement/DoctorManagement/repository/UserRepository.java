package com.Doctormanagement.DoctorManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctormanagement.DoctorManagement.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
public User  findByEmail(String email);
}

