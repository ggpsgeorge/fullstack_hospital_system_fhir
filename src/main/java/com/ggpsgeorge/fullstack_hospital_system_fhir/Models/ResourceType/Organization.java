package com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType.Address;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType.Coding;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType.Telecom;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Organization {

    @Column
    private String resourceType;
    @Id
    private String id;
    @Column
    private String name;
    @Embedded
    @ElementCollection
    private List<Coding> coding = new ArrayList<>();
    @Embedded
    @ElementCollection
    private List<Telecom> telecom = new ArrayList<>();
    @Embedded
    @ElementCollection
    private List<Address> address = new ArrayList<>();
    @OneToMany(mappedBy="hospital")
    private List<Patient> patients = new ArrayList<>();


    public Organization() {
    }

    public Organization(String resourceType, String id, String name, List<Coding> coding, List<Telecom> telecom, List<Address> address, List<Patient> patients) {
        this.resourceType = resourceType;
        this.id = id;
        this.name = name;
        this.coding = coding;
        this.telecom = telecom;
        this.address = address;
        this.patients = patients;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coding> getCoding() {
        return this.coding;
    }

    public void setCoding(List<Coding> coding) {
        this.coding = coding;
    }

    public List<Telecom> getTelecom() {
        return this.telecom;
    }

    public void setTelecom(List<Telecom> telecom) {
        this.telecom = telecom;
    }

    public List<Address> getAddress() {
        return this.address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Organization resourceType(String resourceType) {
        setResourceType(resourceType);
        return this;
    }

    public Organization id(String id) {
        setId(id);
        return this;
    }

    public Organization name(String name) {
        setName(name);
        return this;
    }

    public Organization coding(List<Coding> coding) {
        setCoding(coding);
        return this;
    }

    public Organization telecom(List<Telecom> telecom) {
        setTelecom(telecom);
        return this;
    }

    public Organization address(List<Address> address) {
        setAddress(address);
        return this;
    }

    public Organization patients(List<Patient> patients) {
        setPatients(patients);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) o;
        return Objects.equals(resourceType, organization.resourceType) && Objects.equals(id, organization.id) && Objects.equals(name, organization.name) && Objects.equals(coding, organization.coding) && Objects.equals(telecom, organization.telecom) && Objects.equals(address, organization.address) && Objects.equals(patients, organization.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceType, id, name, coding, telecom, address, patients);
    }

    @Override
    public String toString() {
        return "{" +
            " resourceType='" + getResourceType() + "'" +
            ", id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", coding='" + getCoding() + "'" +
            ", telecom='" + getTelecom() + "'" +
            ", address='" + getAddress() + "'" +
            ", patients='" + getPatients() + "'" +
            "}";
    }
    
}
