package com.Doctormanagement.DoctorManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Doctormanagement.DoctorManagement.model.HeartRateData;
import com.Doctormanagement.DoctorManagement.model.Patient;

public interface HeartRateDataRepository  extends JpaRepository<HeartRateData, Long>{
	   List<HeartRateData> findByPatient(Patient patient);
	}
