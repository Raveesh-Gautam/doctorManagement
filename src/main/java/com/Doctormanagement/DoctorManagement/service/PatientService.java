package com.Doctormanagement.DoctorManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Doctormanagement.DoctorManagement.model.Patient;

@Service
public interface PatientService {
    public ResponseEntity<String> addPatient(Long userId, Patient patient);
    public ResponseEntity<List<Patient>> findPatientsByUserId(Long userId);
    public ResponseEntity<Optional<Patient>> findPatientByPatientIdAndUserId(Long patientId, Long userId);
    // public void deletePatientsByUserId(Long userId);
}
