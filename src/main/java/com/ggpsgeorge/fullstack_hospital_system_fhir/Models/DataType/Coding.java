package com.ggpsgeorge.fullstack_hospital_system_fhir.Models.DataType;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Coding {
    
    @Column
    private String system;
    @Column
    private String code;
    @Column
    private String display;


    public Coding() {
    }

    public Coding(String system, String code, String display) {
        this.system = system;
        this.code = code;
        this.display = display;
    }

    public String getSystem() {
        return this.system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Coding system(String system) {
        setSystem(system);
        return this;
    }

    public Coding code(String code) {
        setCode(code);
        return this;
    }

    public Coding display(String display) {
        setDisplay(display);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Coding)) {
            return false;
        }
        Coding coding = (Coding) o;
        return Objects.equals(system, coding.system) && Objects.equals(code, coding.code) && Objects.equals(display, coding.display);
    }

    @Override
    public int hashCode() {
        return Objects.hash(system, code, display);
    }

    @Override
    public String toString() {
        return "{" +
            " system='" + getSystem() + "'" +
            ", code='" + getCode() + "'" +
            ", display='" + getDisplay() + "'" +
            "}";
    }

}
