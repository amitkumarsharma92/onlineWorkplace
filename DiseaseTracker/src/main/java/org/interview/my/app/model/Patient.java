package org.interview.my.app.model;

import java.util.List;
import java.util.Objects;

public class Patient {
    private String name;

    public String getName() {
        return name;
    }

    public Patient(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
