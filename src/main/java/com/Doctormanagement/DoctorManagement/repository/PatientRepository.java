package com.Doctormanagement.DoctorManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctormanagement.DoctorManagement.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	List<Patient> findByUserUserId(Long userId);
	Optional<Patient> findByPatientIdAndUserUserId(Long patientId, Long userId);


}