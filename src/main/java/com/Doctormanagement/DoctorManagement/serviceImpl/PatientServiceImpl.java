package com.Doctormanagement.DoctorManagement.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Doctormanagement.DoctorManagement.model.Patient;
import com.Doctormanagement.DoctorManagement.model.User;
import com.Doctormanagement.DoctorManagement.repository.PatientRepository;
import com.Doctormanagement.DoctorManagement.repository.UserRepository;
import com.Doctormanagement.DoctorManagement.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> addPatient(Long userId, Patient patient) {
        try {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
            patient.setUser(user);
            patientRepository.save(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<Patient>> findPatientsByUserId(Long userId) {
        try {
            List<Patient> patients = patientRepository.findByUserUserId(userId);
            if (patients.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.emptyList());
        }
    }

    @Override
    public ResponseEntity<Optional<Patient>> findPatientByPatientIdAndUserId(Long patientId, Long userId) {
        try {
            Optional<Patient> patient = patientRepository.findByPatientIdAndUserUserId(patientId, userId);
            if (patient.isPresent()) {
                return ResponseEntity.ok(patient);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

