package com.practice.meesho.app.library;

import com.practice.meesho.app.library.dto.BookRecord;
import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.User;
import com.practice.meesho.app.library.services.BookService;
import com.practice.meesho.app.library.services.UserService;
import com.practice.meesho.app.library.validators.LibraryValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * keep books
 * Help Create User accounts
 */
public class LibraryService {

    private BookService bookService;

    public UserService userService;

    private LibraryValidator userQuotaValidator;

    public LibraryService(BookService bookService, UserService userService, LibraryValidator userQuotaValidator) {
        this.bookService = bookService;
        this.userService = userService;
        this.userQuotaValidator = userQuotaValidator;
    }

    /**
     * Check User exists, user has quota
     * Check book is not already reserved by user
     * Check Book exists, book has pendingCount
     * add user to book, and book to user
     * check
     *
     * @param userName
     * @param bookName
     */
    public String reserveBook(String userName, String bookName) {
        try {
            User user = userService.getUser(userName);
            userQuotaValidator.validate(user);
            bookService.reserveBook(user, bookName);
            return "Success";
        } catch (LibraryException e) {
            return e.getMessage();
        }
    }

    public String returnBook(String userName, String bookName) {
        try {
            User user = userService.getUser(userName);
            bookService.returnBook(user, bookName);
            return "Success";
        } catch (LibraryException e) {
            return e.getMessage();
        }
    }

    public List<User> usersWithBook(String bookName) throws LibraryException {
        Optional<BookRecord> bookrecord = bookService.getBook(bookName);
        if (bookrecord.isPresent()) return new ArrayList<>(bookrecord.get().getReservedBy());
        else {
            throw LibraryException.bookUnregistered(bookName);
        }

    }
}
