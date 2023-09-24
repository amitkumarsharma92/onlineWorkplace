package com.practice.app.inventoryManagement.repo;

import com.practice.app.inventoryManagement.models.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductRepo implements Repo<Product> {
    private Map<String, Product> db;

    private Map<String, Product> barcodeDb;

    public void upsert(Product product) {
        db.put(product.getId(), product);
        barcodeDb.put(product.getBarcode(), product);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public Product getById(String productId) {
        return db.get(productId);
    }

    public Product getByBarcode(String barcode) {
        return barcodeDb.get(barcode);
    }
}
