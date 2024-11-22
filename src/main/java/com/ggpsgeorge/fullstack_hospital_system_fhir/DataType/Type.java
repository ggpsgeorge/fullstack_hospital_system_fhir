package com.ggpsgeorge.fullstack_hospital_system_fhir.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Type {
    private List<Coding> coding = new ArrayList<>();

    public Type() {
    }

    public Type(List<Coding> coding) {
        this.coding = coding;
    }

    public List<Coding> getCoding() {
        return this.coding;
    }

    public void setCoding(List<Coding> coding) {
        this.coding = coding;
    }

    public Type coding(List<Coding> coding) {
        setCoding(coding);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Type)) {
            return false;
        }
        Type type = (Type) o;
        return Objects.equals(coding, type.coding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coding);
    }

    @Override
    public String toString() {
        return "{" +
            " coding='" + getCoding() + "'" +
            "}";
    }
}
