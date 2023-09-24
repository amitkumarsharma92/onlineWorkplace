package com.practice.meesho.app.library.services;

import com.practice.meesho.app.library.dto.BookRecord;
import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.Book;
import com.practice.meesho.app.library.models.User;
import com.practice.meesho.app.library.repository.BookRecordRepository;
import com.practice.meesho.app.library.validators.LibraryValidator;

import java.util.Optional;

/**
 *
 */
public class BookService {
    private BookRecordRepository bookRecordRepository;
    private LibraryValidator userQuotaValidator;

    public BookService(BookRecordRepository bookRecordRepository, LibraryValidator userQuotaValidator) {
        this.bookRecordRepository = bookRecordRepository;
        this.userQuotaValidator = userQuotaValidator;
    }

    public void addBook(String bookName, int count) {
        Optional<BookRecord> bookRecord = getBook(bookName);
        if (bookRecord.isPresent()) {
            bookRecord.get().addBookCount(count);
        }
        bookRecordRepository.insert(new BookRecord(new Book(bookName), count));
    }

    public Optional<BookRecord> getBook(String bookName) {
        BookRecord bookRecord = bookRecordRepository.getById(bookName);
        if (bookRecord == null) return Optional.empty();
        return Optional.of(bookRecord);
    }

    public void reserveBook(User user, String bookName) throws LibraryException {
        Optional<BookRecord> bookrecordOpt = getBook(bookName);
        if (!bookrecordOpt.isPresent()) throw LibraryException.bookUnregistered(bookName);
        BookRecord bookrecord = bookrecordOpt.get();
        userQuotaValidator.validate(bookrecord, user);
        bookrecord.addReservedBy(user);
    }

    public void returnBook(User user, String bookName) throws LibraryException {
        Optional<BookRecord> bookrecordOpt = getBook(bookName);
        if (!bookrecordOpt.isPresent()) throw LibraryException.bookUnregistered(bookName);
        BookRecord bookrecord = bookrecordOpt.get();
        if (!bookrecord.getReservedBy().contains(user)){
            throw LibraryException.bookNotRegisteredWithUser(user.getUserName());
        }
        bookrecord.unregisterUser(user);
    }
}
