package com.practice.app.inventoryManagement.repo;

import com.practice.app.inventoryManagement.enums.SlotStatus;
import com.practice.app.inventoryManagement.enums.SlotType;
import com.practice.app.inventoryManagement.models.Slot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SlotRepo implements Repo<Slot> {
    private Map<String, Slot> db;
    private Map<String, Slot> identierIndex;

    @Override
    public void upsert(Slot slot) {
        db.put(slot.getId(), slot);
        identierIndex.put(slot.getIdentifier(), slot);
    }

    public boolean addSlot(Slot slot) {
        if (db.get(slot.getId()) != null || identierIndex.get(slot.getIdentifier()) != null) return false;
        upsert(slot);
        return true;
    }

    @Override
    public Slot getById(String slotId) {
        return db.get(slotId);
    }

    public Slot getByIdentifier(String slotIdentifier) {
        return identierIndex.get(slotIdentifier);
    }

    public boolean reserveSlot(String slotId) {
        Slot slot = getById(slotId);
        if (slot != null) return slot.reserve();
        return false;
    }

    public List<Slot> reserveSlotBySize(SlotStatus status, SlotType slotType, int count) {
        int counter = 0;
        List<Slot> result = new ArrayList<>();
        for (Slot slot : db.values()) {
            if (slot.getStatus() == status && slot.getType() == slotType) {
                if (slot.reserve()) {
                    result.add(slot);
                    counter++;
                }
            }
            if (count > counter) break;
        }
        return result;
    }

}
