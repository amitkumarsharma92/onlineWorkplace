package com.practice.meesho.app.library.exeptions;

public class LibraryException extends Exception {
    public static String USER_ALREADY_EXISTS = "USER ALREADY EXISTS. ENTER ANOTHER USERNAME";
    public static String USER_DO_NOT_EXISTS = "USER IS NOT REGISTERED.PLEASE REGISTER FIRST";
    public static String USER_QUOTA_EXCEEDED = "USER ALREADY HAS USED UP BOOK COUNT QUOTA";

    public static String BOOK_NOT_CURRENTLY_AVAILABLE = "BOOKS IS NOT CURRENTLY AVAILABLE.TRY AGAIN LATER";
    public static String BOOK_NOT_REGISTERED_WITH_USER = "BOOKS IS NOT CURRENTLY REGISTERED TO YOU";
    public static String UNREGISTERED_BOOK = "BOOK NOT REGISTERED WITH SYSTEM";

    public static String USER_ALREADY_REGISTERED_BOOK = "A BOOK COPY IS ALREADY WITH USER";

    private String reasonCode;

    private Object args;

    public LibraryException(String reasonCode, Object args) {
        super(reasonCode);
        this.args = args;
    }

    public static LibraryException userAlreadyExists(String userName) {
        return new LibraryException(USER_ALREADY_EXISTS, userName);
    }

    public static LibraryException userAlreadyRegisteredBook(String userName) {
        return new LibraryException(USER_ALREADY_REGISTERED_BOOK, userName);
    }


    public static LibraryException userDoNotExists(String userName) {
        return new LibraryException(USER_DO_NOT_EXISTS, userName);
    }

    public static LibraryException userQuotaExceeded(String userName) {
        return new LibraryException(USER_QUOTA_EXCEEDED, userName);
    }

    public static LibraryException bookNotAvailable(String bookName) {
        return new LibraryException(BOOK_NOT_CURRENTLY_AVAILABLE, bookName);
    }

    public static LibraryException bookNotRegisteredWithUser(String bookName) {
        return new LibraryException(BOOK_NOT_REGISTERED_WITH_USER, bookName);
    }

    public static LibraryException bookUnregistered(String bookName) {
        return new LibraryException(UNREGISTERED_BOOK, bookName);
    }
}
