package com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name="address_use")
    private String use;
    @Column
    private List<String> line = new ArrayList<>();
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String postalCode;
    @Column
    private String country;

    public Address() {
    }

    public Address(String use, List<String> line, String city, String state, String postalCode, String country) {
        this.use = use;
        this.line = line;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getUse() {
        return this.use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public List<String> getLine() {
        return this.line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address use(String use) {
        setUse(use);
        return this;
    }

    public Address line(List<String> line) {
        setLine(line);
        return this;
    }

    public Address city(String city) {
        setCity(city);
        return this;
    }

    public Address state(String state) {
        setState(state);
        return this;
    }

    public Address postalCode(String postalCode) {
        setPostalCode(postalCode);
        return this;
    }

    public Address country(String country) {
        setCountry(country);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address adress = (Address) o;
        return Objects.equals(use, adress.use) && Objects.equals(line, adress.line) && Objects.equals(city, adress.city) && Objects.equals(state, adress.state) && Objects.equals(postalCode, adress.postalCode) && Objects.equals(country, adress.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(use, line, city, state, postalCode, country);
    }

    @Override
    public String toString() {
        return "{" +
            " use='" + getUse() + "'" +
            ", line='" + getLine() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
