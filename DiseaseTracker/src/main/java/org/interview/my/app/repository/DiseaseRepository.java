package org.interview.my.app.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.interview.my.app.model.Disease;

public class DiseaseRepository {

    private Map<String, Disease> diseases = new ConcurrentHashMap<>();

    public Disease save(Disease disease) {
        diseases.put(disease.getName(), disease);
        return disease;
    }

    public Disease get(String name) {
        return diseases.get(name);
    }

    public Set<Disease> getAll() {
        return diseases.entrySet().stream().map((entry) -> entry.getValue()).collect(Collectors.toSet());
    }
}
