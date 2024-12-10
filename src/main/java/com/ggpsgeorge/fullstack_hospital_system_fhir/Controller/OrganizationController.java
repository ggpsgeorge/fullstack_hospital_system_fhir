package com.ggpsgeorge.fullstack_hospital_system_fhir.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType.Organization;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType.Patient;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Repository.OrganizationRepository;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Repository.PatientRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/organization/v1")
public class OrganizationController {
    
    @Autowired 
    OrganizationRepository organizationRepository;
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/")
    public ResponseEntity<List<Organization>> addOrganization(@RequestBody List<Organization> organizations) {
        return ResponseEntity.accepted().body(organizationRepository.saveAll(organizations));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String id) {
        try {
            Organization organization = organizationRepository.findById(id).orElseThrow();
            return ResponseEntity.ok().body(organization);
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } 
    }

    @GetMapping("/")
    public ResponseEntity<List<Organization>> getOrganizations() {
        return ResponseEntity.ok().body(organizationRepository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(@PathVariable String id, @RequestBody Organization newOrganization) {
        try {
            organizationRepository.findById(id).orElseThrow();
            Organization organization = organizationRepository.save(newOrganization);
            return ResponseEntity.accepted().body(organization);
            
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/register-patient/{patientId}")
    public ResponseEntity<Organization> registerPatientToHospital(@PathVariable String id, @PathVariable String patientId) {
        try {
            Organization hospital = organizationRepository.findById(id).orElseThrow();
            Patient patient = patientRepository.findById(patientId).orElseThrow();
            List<Patient> hospitalPatients = hospital.getPatients();
            
            hospitalPatients.add(patient);
            patient.setHospital(hospital);
            
            patientRepository.save(patient);
            return ResponseEntity.accepted().body(organizationRepository.save(hospital));

        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganization(@PathVariable String id) {
        try {
            organizationRepository.findById(id).orElseThrow();
            organizationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
