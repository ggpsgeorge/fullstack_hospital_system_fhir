package com.ggpsgeorge.fullstack_hospital_system_fhir.Models.ResourceType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType.Address;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType.Name;
import com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType.Telecom;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Practioner {

    @Column
    private String resourceType;
    @Id
    private String id;
    @Embedded
    @ElementCollection
    private List<Name> name = new ArrayList<>();
    @Column
    private String gender;
    @Column
    private LocalDate birthDate;
    @Embedded
    @ElementCollection
    private List<Telecom> telecom = new ArrayList<>();
    @Embedded
    @ElementCollection
    private List<Address> address = new ArrayList<>();
    @ManyToMany(mappedBy="doctors")
    @JsonIgnore
    private List<Patient> patients = new ArrayList<>();


    public Practioner() {
    }

    public Practioner(String resourceType, String id, List<Name> name, String gender, LocalDate birthDate, List<Telecom> telecom, List<Address> address, List<Patient> patients) {
        this.resourceType = resourceType;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
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

    public List<Name> getName() {
        return this.name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public Practioner resourceType(String resourceType) {
        setResourceType(resourceType);
        return this;
    }

    public Practioner id(String id) {
        setId(id);
        return this;
    }

    public Practioner name(List<Name> name) {
        setName(name);
        return this;
    }

    public Practioner gender(String gender) {
        setGender(gender);
        return this;
    }

    public Practioner birthDate(LocalDate birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public Practioner telecom(List<Telecom> telecom) {
        setTelecom(telecom);
        return this;
    }

    public Practioner address(List<Address> address) {
        setAddress(address);
        return this;
    }

    public Practioner patients(List<Patient> patients) {
        setPatients(patients);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Practioner)) {
            return false;
        }
        Practioner practioner = (Practioner) o;
        return Objects.equals(resourceType, practioner.resourceType) && Objects.equals(id, practioner.id) && Objects.equals(name, practioner.name) && Objects.equals(gender, practioner.gender) && Objects.equals(birthDate, practioner.birthDate) && Objects.equals(telecom, practioner.telecom) && Objects.equals(address, practioner.address) && Objects.equals(patients, practioner.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceType, id, name, gender, birthDate, telecom, address, patients);
    }

    @Override
    public String toString() {
        return "{" +
            " resourceType='" + getResourceType() + "'" +
            ", id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", gender='" + getGender() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", telecom='" + getTelecom() + "'" +
            ", address='" + getAddress() + "'" +
            ", patients='" + getPatients() + "'" +
            "}";
    }


}
