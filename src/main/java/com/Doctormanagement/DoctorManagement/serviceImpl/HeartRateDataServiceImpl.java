package com.Doctormanagement.DoctorManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Doctormanagement.DoctorManagement.model.HeartRateData;
import com.Doctormanagement.DoctorManagement.model.Patient;
import com.Doctormanagement.DoctorManagement.repository.HeartRateDataRepository;
import com.Doctormanagement.DoctorManagement.repository.PatientRepository;
import com.Doctormanagement.DoctorManagement.service.HeartRateDataService;

@Service
public class HeartRateDataServiceImpl implements HeartRateDataService {

    @Autowired
    private HeartRateDataRepository heartRateDataRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public ResponseEntity<HeartRateData> addHeartRateData(Long patientId, HeartRateData heartRateData) {
        try {
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            heartRateData.setPatient(patient);
            HeartRateData savedHeartRateData = heartRateDataRepository.save(heartRateData);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedHeartRateData);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<List<HeartRateData>> getHeartRateData(Long patientId) {
        try {
            Patient patient = patientRepository.findById(patientId)
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            List<HeartRateData> heartRateDataList = heartRateDataRepository.findByPatient(patient);
            return ResponseEntity.ok(heartRateDataList);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }
}
