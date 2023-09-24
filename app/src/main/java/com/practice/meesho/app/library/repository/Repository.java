package com.practice.meesho.app.library.repository;

public interface Repository<T> {

    T getById(String id);
}
