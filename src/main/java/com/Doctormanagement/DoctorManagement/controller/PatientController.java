package com.Doctormanagement.DoctorManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Doctormanagement.DoctorManagement.model.Patient;
import com.Doctormanagement.DoctorManagement.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> addPatient(@PathVariable("userId") Long userId, @RequestBody Patient patient) {
        return patientService.addPatient(userId, patient);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Patient>> getPatientsByUserId(@PathVariable("userId") Long userId) {
        return patientService.findPatientsByUserId(userId);
    }

    @GetMapping("/{patientId}/user/{userId}")
    public ResponseEntity<Optional<Patient>> getPatientByPatientIdAndUserId(@PathVariable("patientId") Long patientId, 
                                                                              @PathVariable("userId") Long userId) {
        return patientService.findPatientByPatientIdAndUserId(patientId, userId);
    }
}
