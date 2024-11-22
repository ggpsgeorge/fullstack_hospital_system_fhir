package com.ggpsgeorge.fullstack_hospital_system_fhir.ResourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ggpsgeorge.fullstack_hospital_system_fhir.DataType.Address;
import com.ggpsgeorge.fullstack_hospital_system_fhir.DataType.Telecom;
import com.ggpsgeorge.fullstack_hospital_system_fhir.DataType.Type;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Organization {

    @Column
    private String resourceType;
    @Id
    private String id;
    @Column
    private String name;
    @ElementCollection
    @Embedded
    private List<Type> type = new ArrayList<>();
    @ElementCollection
    @Embedded
    private List<Telecom> telecom = new ArrayList<>();
    @ElementCollection
    @Embedded
    private List<Address> address = new ArrayList<>();


    public Organization() {
    }

    public Organization(String resourceType, String id, String name, List<Type> type, List<Telecom> telecom, List<Address> address) {
        this.resourceType = resourceType;
        this.id = id;
        this.name = name;
        this.type = type;
        this.telecom = telecom;
        this.address = address;
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

    public List<Type> getType() {
        return this.type;
    }

    public void setType(List<Type> type) {
        this.type = type;
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

    public Organization type(List<Type> type) {
        setType(type);
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) o;
        return Objects.equals(resourceType, organization.resourceType) && Objects.equals(id, organization.id) && Objects.equals(name, organization.name) && Objects.equals(type, organization.type) && Objects.equals(telecom, organization.telecom) && Objects.equals(address, organization.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceType, id, name, type, telecom, address);
    }

    @Override
    public String toString() {
        return "{" +
            " resourceType='" + getResourceType() + "'" +
            ", id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", telecom='" + getTelecom() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
    
}
