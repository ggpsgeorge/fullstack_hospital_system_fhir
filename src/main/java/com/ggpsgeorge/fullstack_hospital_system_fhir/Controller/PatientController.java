package com.ggpsgeorge.fullstack_hospital_system_fhir.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType.Patient;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Repository.PatientRepository;

@RestController
@RequestMapping("/api/patient/v1")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/")
    public ResponseEntity<List<Patient>> addPatients(@RequestBody List<Patient> patients) {
        return ResponseEntity.accepted().body(patientRepository.saveAll(patients)); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id){
        try {
            Patient patient = patientRepository.findById(id).orElseThrow();
            return ResponseEntity.ok().body(patient);
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @RequestBody Patient newPatient) {
        try {
            patientRepository.findById(id).orElseThrow();
            Patient patient = patientRepository.save(newPatient);
            return ResponseEntity.accepted().body(patient);
            
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        try {
            patientRepository.findById(id).orElseThrow();
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
