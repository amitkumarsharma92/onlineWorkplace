package org.interview.my.app.view;

import org.interview.my.app.model.DiseaseCases;
import org.interview.my.app.model.DiseaseStats;

import java.util.Map;

public class ReportingViewManager {

    public void display(DiseaseStats stat, String statLevel) {
        System.out.println("------------------");
        System.out.println(statLevel + " Stat ->");
        displayBreifStat(stat);
    }

    public void display(Map<String, DiseaseStats> statsMap, String statLevel) {
        System.out.println("------------------");
        System.out.println(statLevel + " Stat ->");
        int listItemCounter = 1;
        for (Map.Entry<String, DiseaseStats> entry : statsMap.entrySet()) {
            DiseaseStats stat = entry.getValue();
            System.out.println("\t" + listItemCounter++ + ". " + entry.getValue().getDiseaseName());
            displayBreifStat(stat);
        }
    }

    private void displayBreifStat(DiseaseStats stat) {
        System.out.println("\ti.   Total : " + stat.getTotal());
        System.out.println("\tii.  Cured : " + stat.getRecovered());
        System.out.println("\tiii. Fatality : " + stat.getFatality());
        System.out.println("\tiv.  Active : " + stat.getActive());
    }
}
