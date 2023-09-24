package com.practice.app.inventoryManagement.services;

import com.practice.app.inventoryManagement.enums.SlotStatus;
import com.practice.app.inventoryManagement.enums.SlotType;
import com.practice.app.inventoryManagement.models.Slot;
import com.practice.app.inventoryManagement.repo.SlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    @Autowired
    private SlotRepo slotRepo;

    public boolean addSlot(Slot slot) {
        return slotRepo.addSlot(slot);
    }

    public List<Slot> reserveAvailableSlots(SlotType slotType, int count) {
        return slotRepo.reserveSlotBySize(SlotStatus.AVAILABLE, slotType, count);
    }

    public List<Slot> getSlotUnitInfo(SlotType slotType, int count) {
        return slotRepo.reserveSlotBySize(SlotStatus.AVAILABLE, slotType, count);
    }

    public Slot getSlotInfo(String slotIdentifier) {
        return slotRepo.getByIdentifier(slotIdentifier);
    }
}
