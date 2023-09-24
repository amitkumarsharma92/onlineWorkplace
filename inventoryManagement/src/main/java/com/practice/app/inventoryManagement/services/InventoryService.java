package com.practice.app.inventoryManagement.services;

import com.practice.app.inventoryManagement.enums.SlotType;
import com.practice.app.inventoryManagement.models.*;
import com.practice.app.inventoryManagement.repo.UnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private ProductService productService;

    @Autowired
    private SlotService slotService;

    @Autowired
    private UnitRepo unitRepo;

    public void storeItem(Instruction instruction) {
        String barcode = instruction.getBarcode();
        Product product = productService.getProductSizeByBarcode(barcode);
        Optional<SlotType> slotType = productService.getProductSlotType(product);
        if (slotType.isPresent()) {
            List<Slot> slots = slotService.reserveAvailableSlots(slotType.get(), instruction.getUnitCount());
            instruction.reservedSlots(slots);
            for (Slot slot : slots) {
                unitRepo.upsert(new Unit(product, slot));
            }
        } else {
            instruction.setRequestStatus("NOT_FOUND");
        }
    }

    public void pickItemFromSlot(Pick pick) {
        Slot slot = slotService.getSlotInfo(pick.getSlotIdentifier());
        if (slot != null) {
            Unit unit = unitRepo.getById(slot.getId());
            if (unit != null) {
                pick.setProduct(unit.getProduct());
                slot.free();
            }
        }
        pick.setRequestStatus("NOT_FOUND");
    }
}
