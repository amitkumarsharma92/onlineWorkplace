package org.interview.my.app;

import org.interview.my.app.dao.DiseaseCasesDao;
import org.interview.my.app.model.enums.DiseaseSource;
import org.interview.my.app.model.enums.TransmissionMedium;
import org.interview.my.app.model.enums.TransmissionType;
import org.interview.my.app.repository.DiseaseCasesRepository;
import org.interview.my.app.repository.DiseaseRepository;
import org.interview.my.app.service.CasesReportingManager;
import org.interview.my.app.view.ReportingViewManager;
import org.interview.my.app.service.TrackerService;

public class AppDriver {
    private TrackerService trackerService;
    private CasesReportingManager reportingManager;

    public void init() {
        DiseaseCasesDao diseaseCasesDao = getDiseaseCasesDao();
        this.reportingManager = new CasesReportingManager(diseaseCasesDao, new ReportingViewManager());
        this.trackerService = new TrackerService(diseaseCasesDao);
    }

    private DiseaseCasesDao getDiseaseCasesDao() {
        return new DiseaseCasesDao(new DiseaseRepository(), new DiseaseCasesRepository());
    }

    public void populateData() {
        try {
            registerDisease();
            System.out.println("Diseases Registered");
            registerCases();
            System.out.println("Cases Registered");
            displayReports();
            System.out.println("Display Completed ");
            patientUpdates();
            displayReports2();
        } catch (Exception e) {
            assert false;
        }

    }

    private void registerDisease() {
        trackerService.registerDisease("COVID-19", DiseaseSource.VIRAL, TransmissionType.TRANSMISSIBLE, TransmissionMedium.AIR);
        trackerService.registerDisease("HUNGER", DiseaseSource.ECONOMY, TransmissionType.NON_TRANSMISSIBLE, TransmissionMedium.NONE);
        trackerService.registerDisease("TYPHOID", DiseaseSource.Bacterial, TransmissionType.TRANSMISSIBLE, TransmissionMedium.WATER);
        trackerService.registerDisease("Spanish Flu", DiseaseSource.VIRAL, TransmissionType.TRANSMISSIBLE, TransmissionMedium.AIR);
    }

    private void registerCases() throws Exception {
        trackerService.report("COVID-19", "P1", "China", "Hubei", "Wuhan");
        trackerService.report("COVID-19", "P2", "China", "Hubei", "Wuhan");
        trackerService.report("COVID-19", "P3", "China", "Jiangsu", "Shanghai");
        trackerService.report("COVID-19", "P4", "India", "Uttar Pradesh", "Agra");
        trackerService.report("COVID-19", "P5", "India", "Uttar Pradesh", "Varanasi");
        trackerService.report("COVID-19", "P6", "India", "Karnataka", "Bangalore");
        trackerService.report("COVID-19", "P7", "India", "Karnataka", "Bangalore");
        trackerService.report("COVID-19", "P8", "India", "Karnataka", "Bangalore");
        registerCase("Spanish Flu", "P9", "USA", "California", "Los Angeles");
        registerCase("Spanish Flu", "P10", "USA", "California", "San-francisco");
    }

    private void registerCase(String diseaseName, String personId, String country, String state, String city) {
        try {
            trackerService.report(diseaseName, personId, country, state, city);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }

    private void displayReports() {
        reportingManager.showWorldSummary();
        reportingManager.showWorldSummaryDiseaseWise();
    }

    private void patientUpdates() {
        trackerService.cured("COVID-19", "P8");
        trackerService.registerFatality("COVID-19", "P2");
    }
    private void displayReports2() {
        reportingManager.showDiseaseSummaryCountryWise("COVID-19");
        reportingManager.showDiseaseCountrySummaryStateWise("COVID-19", "India");
//        reportingManager.showWorldSummaryDiseaseWise();
    }

}
