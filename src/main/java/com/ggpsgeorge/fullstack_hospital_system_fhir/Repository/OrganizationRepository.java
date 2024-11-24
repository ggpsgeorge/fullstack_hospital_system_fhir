package com.ggpsgeorge.fullstack_hospital_system_fhir.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {
    
}
