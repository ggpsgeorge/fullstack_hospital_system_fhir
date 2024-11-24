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
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType.Practioner;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Repository.PatientRepository;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Repository.PractionerRepository;

@RestController
@RequestMapping("/api/patient/v1")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PractionerRepository practionerRepository;

    @PostMapping("/")
    public ResponseEntity<List<Patient>> addPatients(@RequestBody List<Patient> patients) {
        return ResponseEntity.accepted().body(patientRepository.saveAll(patients)); 
    }

    @PostMapping("/{id}/register-doctor/{doctorId}")
    public ResponseEntity<Patient> registerDoctorToPatient(@PathVariable String id, @PathVariable String doctorId) {
        try {
            Practioner doctor = practionerRepository.findById(doctorId).orElseThrow();
            Patient patient = patientRepository.findById(id).orElseThrow();
            List<Practioner> patientDoctors = patient.getDoctors();
            patientDoctors.add(doctor);
            patient.setDoctors(patientDoctors);
            
            return ResponseEntity.accepted().body(patientRepository.save(patient));

        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
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
