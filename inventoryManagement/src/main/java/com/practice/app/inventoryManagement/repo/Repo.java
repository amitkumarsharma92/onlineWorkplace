package com.practice.app.inventoryManagement.repo;

public interface Repo<T> {

    void upsert(T obj);

    T getById(String id);
}
