package org.interview.my.app.model;

import org.interview.my.app.model.enums.PatientStatus;

public class DiseaseStats {
    private String diseaseName;
    private String level;
    private Integer active = 0;
    private Integer recovered = 0;
    private Integer fatality = 0;

    public DiseaseStats(String diseaseName, String level) {
        this.diseaseName = diseaseName;
        this.level = level;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public Integer getTotal() {
        return active + recovered + fatality;
    }

    public Integer getActive() {
        return active;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public Integer getFatality() {
        return fatality;
    }

    public void incrementStat(PatientStatus status) {
        switch (status) {
            case ACTIVE:
                active++;
                break;
            case RECOVERED:
                recovered++;
                break;
            case DECEASED:
                fatality++;
                break;
        }
    }
}

