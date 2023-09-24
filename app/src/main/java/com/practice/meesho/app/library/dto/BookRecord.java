package com.practice.meesho.app.library.dto;

import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.Book;
import com.practice.meesho.app.library.models.User;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class BookRecord {
    private Book book;
    private Set<User> reservedBy;
    private AtomicInteger pendingCount;
    private int totalCount;

    public BookRecord(Book book, int totalCount) {
        this.book = book;
        this.reservedBy = new HashSet<>();
        this.pendingCount = new AtomicInteger(totalCount);
        this.totalCount = totalCount;
    }

    public Book getBook() {
        return book;
    }

    public Set<User> getReservedBy() {
        return reservedBy;
    }

    public synchronized void addReservedBy(User user) throws LibraryException {
        if (getPendingCount() <= 0) throw LibraryException.bookNotAvailable(this.getBook().getBookName());
        this.reservedBy.add(user);
        this.pendingCount.getAndDecrement();
        user.addBook(this.getBook());
    }
    public synchronized void unregisterUser(User user) {
        this.reservedBy.remove(user);
        this.pendingCount.getAndIncrement();
        user.removeBook(this.getBook());
    }

    public int getPendingCount() {
        return pendingCount.get();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void addBookCount(int count) {
        pendingCount.getAndAdd(count);
        totalCount += count;
    }


}
