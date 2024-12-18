package com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Name {
    @Column(name="name_use")
    private String use;
    @Column
    private String family;
    @Column
    private List<String> given = new ArrayList<>();
    @Column
    private List<String> prefix = new ArrayList<>();


    public Name() {
    }

    public Name(String use, String family, List<String> given, List<String> prefix) {
        this.use = use;
        this.family = family;
        this.given = given;
        this.prefix = prefix;
    }

    public String getUse() {
        return this.use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<String> getGiven() {
        return this.given;
    }

    public void setGiven(List<String> given) {
        this.given = given;
    }

    public List<String> getPrefix() {
        return this.prefix;
    }

    public void setPrefix(List<String> prefix) {
        this.prefix = prefix;
    }

    public Name use(String use) {
        setUse(use);
        return this;
    }

    public Name family(String family) {
        setFamily(family);
        return this;
    }

    public Name given(List<String> given) {
        setGiven(given);
        return this;
    }

    public Name prefix(List<String> prefix) {
        setPrefix(prefix);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Name)) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(use, name.use) && Objects.equals(family, name.family) && Objects.equals(given, name.given) && Objects.equals(prefix, name.prefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(use, family, given, prefix);
    }

    @Override
    public String toString() {
        return "{" +
            " use='" + getUse() + "'" +
            ", family='" + getFamily() + "'" +
            ", given='" + getGiven() + "'" +
            ", prefix='" + getPrefix() + "'" +
            "}";
    }
}
