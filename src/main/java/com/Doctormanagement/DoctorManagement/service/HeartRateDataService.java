package com.Doctormanagement.DoctorManagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Doctormanagement.DoctorManagement.model.HeartRateData;

@Service
public interface HeartRateDataService {
    public ResponseEntity<HeartRateData> addHeartRateData(Long patientId, HeartRateData heartRateData);
    public ResponseEntity<List<HeartRateData>> getHeartRateData(Long patientId);
}
