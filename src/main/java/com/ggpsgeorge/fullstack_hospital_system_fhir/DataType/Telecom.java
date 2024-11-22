package com.ggpsgeorge.fullstack_hospital_system_fhir.DataType;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Telecom {
    @Column
    private String system;
    @Column
    private String value;
    @Column
    private String use;


    public Telecom() {
    }

    public Telecom(String system, String value, String use) {
        this.system = system;
        this.value = value;
        this.use = use;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUse() {
        return this.use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Telecom system(String system) {
        setSystem(system);
        return this;
    }

    public Telecom value(String value) {
        setValue(value);
        return this;
    }

    public Telecom use(String use) {
        setUse(use);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Telecom)) {
            return false;
        }
        Telecom telecom = (Telecom) o;
        return Objects.equals(system, telecom.system) && Objects.equals(value, telecom.value) && Objects.equals(use, telecom.use);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system, value, use);
    }

    @Override
    public String toString() {
        return "{" +
            " system='" + getSystem() + "'" +
            ", value='" + getValue() + "'" +
            ", use='" + getUse() + "'" +
            "}";
    }
    
}
