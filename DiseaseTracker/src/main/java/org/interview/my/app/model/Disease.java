package org.interview.my.app.model;

import org.interview.my.app.model.enums.DiseaseSource;
import org.interview.my.app.model.enums.TransmissionMedium;
import org.interview.my.app.model.enums.TransmissionType;

import java.util.Objects;

public class Disease {
    String name;
    DiseaseSource source;
    TransmissionType transmissibleType;
    TransmissionMedium medium;

    public String getName() {
        return name;
    }

    public DiseaseSource getSource() {
        return source;
    }

    public TransmissionType getTransmissible() {
        return transmissibleType;
    }

    public TransmissionMedium getMedium() {
        return medium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disease disease = (Disease) o;
        return Objects.equals(name, disease.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private Disease() {
        super();
    }

    public static DiseaseBuilder builder() {
        return new DiseaseBuilder();
    }

    public static class DiseaseBuilder {
        private Disease disease;

        public DiseaseBuilder() {
            super();
            this.disease = new Disease();
        }

        public DiseaseBuilder setName(String name) {
            this.disease.name = name;
            return this;
        }

        public DiseaseBuilder setSource(DiseaseSource source) {
            this.disease.source = source;
            return this;
        }


        public DiseaseBuilder setMedium(TransmissionMedium medium) {
            this.disease.medium = medium;
            return this;
        }

        public DiseaseBuilder setTransmissibleType(TransmissionType transmissibleType) {
            this.disease.transmissibleType = transmissibleType;
            return this;
        }

        public Disease build() {
            return this.disease;
        }
    }
}
