package com.practice.app.inventoryManagement.repo;

import com.practice.app.inventoryManagement.models.Unit;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UnitRepo implements Repo<Unit> {
    private Map<String, Unit> slotdb;
    private Map<String, Unit> barcodeIndex;

    @Override
    public void upsert(Unit units) {
        slotdb.put(units.getSlotId(), units);
        barcodeIndex.put(units.getBarcode(), units);
    }

    @Override
    public Unit getById(String slotId) {
        return slotdb.get(slotId);
    }

    public Unit getByBarcode(String barcode) {
        return barcodeIndex.get(barcode);
    }

}
