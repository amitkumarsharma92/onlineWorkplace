package com.practice.meesho.app.library.validators;

import com.practice.meesho.app.library.dto.BookRecord;
import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.User;

public interface LibraryValidator {

    void validate(User user) throws LibraryException;

    void validate(BookRecord bookrecord, User user) throws LibraryException;
}
