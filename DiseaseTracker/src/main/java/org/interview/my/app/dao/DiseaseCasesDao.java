package org.interview.my.app.dao;

import org.interview.my.app.model.Disease;
import org.interview.my.app.model.DiseaseCases;
import org.interview.my.app.model.enums.PatientStatus;
import org.interview.my.app.repository.DiseaseCasesRepository;
import org.interview.my.app.repository.DiseaseRepository;

import java.util.List;
import java.util.Set;

public class DiseaseCasesDao {
    private DiseaseCasesRepository diseaseCasesRepository;
    private DiseaseRepository diseaseRepository;

    public DiseaseCasesDao(DiseaseRepository diseaseRepository, DiseaseCasesRepository diseaseCasesRepository) {
        this.diseaseRepository = diseaseRepository;
        this.diseaseCasesRepository = diseaseCasesRepository;
    }

    public Disease addDisease(Disease disease) {
        return diseaseRepository.save(disease);
    }

    public Disease getDisease(String diseaseName) {
        return diseaseRepository.get(diseaseName);
    }

    public DiseaseCases addDiseaseCase(DiseaseCases diseaseCases) {
        return diseaseCasesRepository.save(diseaseCases);
    }

    public List<DiseaseCases> getAllCases() {
        return diseaseCasesRepository.getAll();
    }

    public List<DiseaseCases> getAllCasesByDisease(String diseaseName) {
        return diseaseCasesRepository.getAllCasesByDisease(diseaseName);
    }

    public List<DiseaseCases> getDiseaseCasesByCountry(String diseaseName, String country) {
        return diseaseCasesRepository.getDiseaseCasesByCountry(diseaseName, country);
    }

    public void updatePatientStatus(String diseaseName, String personId, PatientStatus currentStatus) {
        DiseaseCases cases = diseaseCasesRepository.get(diseaseName, personId);
        cases.setStatus(currentStatus);
    }
}
