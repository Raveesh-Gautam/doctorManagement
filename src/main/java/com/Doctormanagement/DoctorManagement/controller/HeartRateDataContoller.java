package com.Doctormanagement.DoctorManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Doctormanagement.DoctorManagement.model.HeartRateData;
import com.Doctormanagement.DoctorManagement.service.HeartRateDataService;

@RestController
@RequestMapping("/api/heart-rate")
public class HeartRateDataContoller {

    @Autowired
    private HeartRateDataService heartRateDataService;

    @PostMapping("/{patientId}")
    public ResponseEntity<HeartRateData> addHeartRateData(@PathVariable("patientId") Long patientId,
                                                          @RequestBody HeartRateData heartRateData) {
        return heartRateDataService.addHeartRateData(patientId, heartRateData);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<HeartRateData>> getHeartRateData(@PathVariable("patientId") Long patientId) {
        return heartRateDataService.getHeartRateData(patientId);
    }

}
