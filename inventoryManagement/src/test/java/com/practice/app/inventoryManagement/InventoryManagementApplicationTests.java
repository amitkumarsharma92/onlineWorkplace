package com.practice.app.inventoryManagement;

import com.practice.app.inventoryManagement.enums.SlotType;
import com.practice.app.inventoryManagement.models.Slot;
import com.practice.app.inventoryManagement.services.InventoryService;
import com.practice.app.inventoryManagement.services.SlotService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryManagementApplicationTests {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private SlotService slotService;


    @Before
    public void before() {
        slotService.addSlot(new Slot("R1H1-1", "ROW1-H1-001", SlotType.SMALL));
        slotService.addSlot(new Slot("R1H1-2", "ROW1-H1-003", SlotType.SMALL));
        slotService.addSlot(new Slot("R1H1-3", "ROW1-H1-004", SlotType.SMALL));
        slotService.addSlot(new Slot("R1H1-4", "ROW1-H1-005", SlotType.SMALL));
        slotService.addSlot(new Slot("R1H1-5", "ROW1-H1-006", SlotType.SMALL));
        slotService.addSlot(new Slot("R1H1-6", "ROW1-H1-007", SlotType.SMALL));
        slotService.addSlot(new Slot("R1H1-7", "ROW1-H1-008", SlotType.SMALL));

        slotService.addSlot(new Slot("R1H2-1", "ROW1-H2-001", SlotType.MEDIUM));
        slotService.addSlot(new Slot("R1H2-2", "ROW1-H2-003", SlotType.MEDIUM));
        slotService.addSlot(new Slot("R1H2-3", "ROW1-H2-004", SlotType.MEDIUM));
        slotService.addSlot(new Slot("R1H2-4", "ROW1-H2-005", SlotType.MEDIUM));
        slotService.addSlot(new Slot("R1H2-5", "ROW1-H2-006", SlotType.MEDIUM));


    }

    @Test
    void contextLoads() {
    }

}
