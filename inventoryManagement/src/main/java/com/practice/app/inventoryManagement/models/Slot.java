package com.practice.app.inventoryManagement.models;

import com.practice.app.inventoryManagement.enums.SlotStatus;
import com.practice.app.inventoryManagement.enums.SlotType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Slot {
    private String id;
    private String identifier;
    private SlotType type;
    private SlotStatus status;

    public Slot(String id, String identifier, SlotType type) {
        this.id = id;
        this.identifier = identifier;
        this.type = type;
        this.status = SlotStatus.AVAILABLE;
    }

    synchronized public boolean reserve() {
        if (this.status == SlotStatus.FULL) return false;
        else {
            this.status = SlotStatus.FULL;
            return true;
        }
    }

    synchronized public void free() {
        this.status = SlotStatus.AVAILABLE;
    }
}
