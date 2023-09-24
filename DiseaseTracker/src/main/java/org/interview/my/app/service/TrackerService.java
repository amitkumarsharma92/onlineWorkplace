package org.interview.my.app.service;

import org.interview.my.app.dao.DiseaseCasesDao;
import org.interview.my.app.model.*;
import org.interview.my.app.model.Disease;
import org.interview.my.app.model.enums.DiseaseSource;
import org.interview.my.app.model.enums.PatientStatus;
import org.interview.my.app.model.enums.TransmissionMedium;
import org.interview.my.app.model.enums.TransmissionType;


public class TrackerService {

    private final DiseaseCasesDao diseaseCasesDao;

    public TrackerService(DiseaseCasesDao diseaseCasesDao) {
        this.diseaseCasesDao = diseaseCasesDao;
    }

    public Disease registerDisease(String name, DiseaseSource source, TransmissionType transmissionType, TransmissionMedium medium) {
        Disease disease = Disease.builder().setName(name).setSource(source).setTransmissibleType(transmissionType).setMedium(medium).build();
        return diseaseCasesDao.addDisease(disease);
    }

    public void report(String diseaseName, String personId, String country, String state, String city) throws Exception {
        CaseLocation location = new CaseLocation(country, state, city);
        Disease disease = diseaseCasesDao.getDisease(diseaseName);
        if (disease == null) {
            throw new Exception("REGISTER_DISEASE_FIRST");
        }
        DiseaseCases diseaseCases = new DiseaseCases(disease, new Patient(personId), PatientStatus.ACTIVE, location);
        diseaseCasesDao.addDiseaseCase(diseaseCases);
    }

    public void registerFatality(String diseaseName, String personId) {
        diseaseCasesDao.updatePatientStatus(diseaseName, personId, PatientStatus.DECEASED);
    }

    public void cured(String diseaseName, String personId) {
        diseaseCasesDao.updatePatientStatus(diseaseName, personId, PatientStatus.RECOVERED);
    }
}
