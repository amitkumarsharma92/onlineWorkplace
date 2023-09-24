package org.interview.my.app.repository;

import org.interview.my.app.model.Disease;
import org.interview.my.app.model.DiseaseCases;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DiseaseCasesRepository {

    private Map<String, DiseaseCases> diseaseCases = new ConcurrentHashMap<>();

    public DiseaseCases save(DiseaseCases diseaseCase) {
        diseaseCases.put(diseaseCase.getId(), diseaseCase);
        return diseaseCase;
    }

    public DiseaseCases get(String name, String patientId) {
        return diseaseCases.get(name + "__" + patientId);
    }

    public List<DiseaseCases> getAll() {
        return diseaseCases.entrySet().stream().map((entry) -> entry.getValue()).collect(Collectors.toList());
    }

    public List<DiseaseCases> getDiseaseCasesByCountry(String diseaseName, String country) {
        return diseaseCases.entrySet().stream().map((entry) -> entry.getValue())
                .filter(diseaseCase -> country.equalsIgnoreCase(diseaseCase.getCountry()))
                .filter(diseaseCase -> diseaseName.equalsIgnoreCase(diseaseCase.getDisease().getName()))
                .collect(Collectors.toList());
    }

    public List<DiseaseCases> getAllCasesByDisease(String diseaseName) {
        return diseaseCases.entrySet().stream().map((entry) -> entry.getValue())
                .filter(diseaseCase -> diseaseName.equalsIgnoreCase(diseaseCase.getDisease().getName()))
                .collect(Collectors.toList());
    }
}
