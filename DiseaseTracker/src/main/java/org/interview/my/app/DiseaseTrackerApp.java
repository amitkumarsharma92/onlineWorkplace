package org.interview.my.app;

import org.interview.my.app.dao.DiseaseCasesDao;
import org.interview.my.app.model.enums.DiseaseSource;
import org.interview.my.app.model.enums.TransmissionMedium;
import org.interview.my.app.model.enums.TransmissionType;
import org.interview.my.app.repository.DiseaseCasesRepository;
import org.interview.my.app.repository.DiseaseRepository;
import org.interview.my.app.service.TrackerService;

public class DiseaseTrackerApp {

    public static void main(String[] args) {
        AppDriver driver = new AppDriver();
        driver.init();
        driver.populateData();
    }
}

