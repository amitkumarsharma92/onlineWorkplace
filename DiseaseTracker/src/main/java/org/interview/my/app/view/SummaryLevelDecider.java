package org.interview.my.app.view;

import org.interview.my.app.model.DiseaseCases;

public interface SummaryLevelDecider {
    String getLevel(DiseaseCases diseaseCases);
}
