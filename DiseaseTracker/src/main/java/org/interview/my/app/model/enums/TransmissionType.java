package org.interview.my.app.model.enums;

public enum TransmissionType {
    TRANSMISSIBLE("TRANSMISSIBLE"), NON_TRANSMISSIBLE("NON-TRANSMISSIBLE");
    public final String label;

    private TransmissionType(String label) {
        this.label = label;
    }
}
