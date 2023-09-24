package com.practice.app.inventoryManagement.services;

import com.practice.app.inventoryManagement.enums.SlotType;
import com.practice.app.inventoryManagement.models.Product;
import com.practice.app.inventoryManagement.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product getProductSizeByBarcode(String barcode) {
        return productRepo.getByBarcode(barcode);
    }

    public Optional<SlotType> getProductSlotType(Product product) {
        if (product != null) {
            return Optional.of(product.getSlotType());
        }
        return Optional.empty();
    }
}
