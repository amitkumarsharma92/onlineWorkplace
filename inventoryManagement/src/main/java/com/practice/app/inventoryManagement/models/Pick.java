package com.practice.app.inventoryManagement.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pick {
    private String slotIdentifier;
    private String requestStatus;

    private Product product;
}
