package org.interview.my.app.service;

import org.interview.my.app.dao.DiseaseCasesDao;
import org.interview.my.app.model.DiseaseCases;
import org.interview.my.app.model.DiseaseStats;
import org.interview.my.app.view.ReportingViewManager;
import org.interview.my.app.view.SummaryLevelDecider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CasesReportingManager {
    private DiseaseCasesDao diseaseCasesDao;
    private ReportingViewManager reportingViewManager;

    public static final String WORLD = "WORLD";

    public CasesReportingManager(DiseaseCasesDao diseaseCasesDao,
                                 ReportingViewManager reportingViewManager) {
        this.diseaseCasesDao = diseaseCasesDao;
        this.reportingViewManager = reportingViewManager;
    }

    public void showWorldSummary() {
        List<DiseaseCases> allCases = diseaseCasesDao.getAllCases();
        DiseaseStats stat = getWorldSummary(allCases, WORLD);
        reportingViewManager.display(stat, WORLD);
    }

    public void showWorldSummaryDiseaseWise() {
        List<DiseaseCases> allCases = diseaseCasesDao.getAllCases();
        Map<String, DiseaseStats> statsMap = getReportSummaryLevelWise(allCases, WORLD, (diseaseCases -> diseaseCases.getDisease().getName()));
        reportingViewManager.display(statsMap, WORLD);
    }

    public void showDiseaseSummaryCountryWise(String diseaseName) {
        List<DiseaseCases> allCases = diseaseCasesDao.getAllCasesByDisease(diseaseName);
        Map<String, DiseaseStats> statsMap =
                getReportSummaryLevelWise(allCases, diseaseName, (diseaseCases -> diseaseCases.getCountry()));
        reportingViewManager.display(statsMap, diseaseName);
    }

    public void showDiseaseCountrySummaryStateWise(String diseaseName, String country) {
        List<DiseaseCases> allCases = diseaseCasesDao.getDiseaseCasesByCountry(diseaseName, country);
        Map<String, DiseaseStats> statsMap = getReportSummaryLevelWise(allCases, country, (diseaseCases -> diseaseCases.getLocation().getState()));
        reportingViewManager.display(statsMap, diseaseName);
    }

    private DiseaseStats getWorldSummary(List<DiseaseCases> allCases, String statLevel) {
        DiseaseStats stat = new DiseaseStats(statLevel, statLevel);
        for (DiseaseCases cases : allCases) {
            stat.incrementStat(cases.getStatus());
        }
        return stat;
    }

    private Map<String, DiseaseStats> getReportSummaryLevelWise(List<DiseaseCases> allCases, String statLevel, SummaryLevelDecider decider) {
        Map<String, DiseaseStats> diseaseWorldStateMap = new HashMap<>();
        for (DiseaseCases cases : allCases) {
            String reportLevel = decider.getLevel(cases);
            DiseaseStats stat = diseaseWorldStateMap.get(reportLevel);
            if (stat == null) {
                stat = new DiseaseStats(reportLevel, statLevel);
                diseaseWorldStateMap.put(reportLevel, stat);
            }
            stat.incrementStat(cases.getStatus());
        }
        return diseaseWorldStateMap;
    }

}
