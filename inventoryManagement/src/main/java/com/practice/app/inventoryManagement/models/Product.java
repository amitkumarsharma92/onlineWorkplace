package com.practice.app.inventoryManagement.models;

import com.practice.app.inventoryManagement.enums.SlotType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private String id;
    private String barcode;
    private SlotType slotType;
    private double price;
}
