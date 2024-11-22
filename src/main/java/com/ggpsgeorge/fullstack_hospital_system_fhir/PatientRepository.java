package com.ggpsgeorge.fullstack_hospital_system_fhir;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggpsgeorge.fullstack_hospital_system_fhir.ResourceType.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{
    
}
