package com.practice.meesho.app.library.validators;

import com.practice.meesho.app.library.dto.BookRecord;
import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.User;

import java.util.Set;

public class UserQuotaValidator implements LibraryValidator {
    private static int USER_BOOK_QUOTA = 2;

    @Override
    public void validate(User user) throws LibraryException {
        if (user.getBookCount() >= USER_BOOK_QUOTA) {
            throw LibraryException.userQuotaExceeded(user.getUserName());
        }
    }

    @Override
    public void validate(BookRecord bookrecord, User user) throws LibraryException {
        Set<User> users = bookrecord.getReservedBy();
        if (user != null || !users.isEmpty()) {
            if (users.contains(user)) {
                throw LibraryException.userAlreadyRegisteredBook(user.getUserName());
            }
        }
    }
}
