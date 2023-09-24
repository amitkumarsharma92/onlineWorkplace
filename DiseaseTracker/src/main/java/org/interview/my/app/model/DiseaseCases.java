package org.interview.my.app.model;

import org.interview.my.app.model.enums.PatientStatus;

public class DiseaseCases {
    Disease disease;
    Patient patient;
    PatientStatus status;
    CaseLocation location;

    public String getId() {
        return this.disease.getName() + "__" + this.patient.getName();
    }

    public DiseaseCases(Disease name, Patient patient, PatientStatus status, CaseLocation location) {
        this.disease = name;
        this.patient = patient;
        this.status = status;
        this.location = location;
    }

    public Disease getDisease() {
        return disease;
    }

    public Patient getPatient() {
        return patient;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public CaseLocation getLocation(){
        return location;
    }

    public String getCountry(){
        return getLocation().getCountry();
    }
}
