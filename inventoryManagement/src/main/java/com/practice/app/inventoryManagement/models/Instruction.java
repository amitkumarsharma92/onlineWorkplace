package com.practice.app.inventoryManagement.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Instruction {
    private String barcode;
    private String itemId;
    private int unitCount;
    private String requestStatus;
    private List<Slot> slots;

    public void reservedSlots(List<Slot> slots) {
        this.slots = slots;
        if (slots.size() == unitCount) {
            this.requestStatus = "SERVED";
        } else if (slots.isEmpty()){
            this.requestStatus = "NOT_SERVED";
        }else{
            this.requestStatus = "PARTIAL";
        }
    }
}
