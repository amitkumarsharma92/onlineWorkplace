package com.practice.meesho.app.library.repository;

import com.practice.meesho.app.library.dto.BookRecord;

import java.util.HashMap;
import java.util.Map;

public class BookRecordRepository implements Repository<BookRecord> {

    Map<String, BookRecord> bookTable = new HashMap<>();

    @Override
    public BookRecord getById(String bookName) {
        return bookTable.get(bookName);
    }

    public void insert(BookRecord bookRecord) {
        bookTable.put(bookRecord.getBook().getBookName(), bookRecord);
    }

}
