package com.practice.app.inventoryManagement.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Unit {
    private Product product;
    private Slot slot;

    public Unit(Product product, Slot slot) {
        this.product = product;
        this.slot = slot;
    }

    public String getBarcode() {
        return product.getBarcode();
    }

    public String getSlotId() {
        return slot.getId();
    }
}
