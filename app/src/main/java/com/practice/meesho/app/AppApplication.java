package com.practice.meesho.app;

import com.practice.meesho.app.library.LibraryService;
import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.User;
import com.practice.meesho.app.library.repository.BookRecordRepository;
import com.practice.meesho.app.library.repository.UserRepository;
import com.practice.meesho.app.library.services.BookService;
import com.practice.meesho.app.library.services.UserService;
import com.practice.meesho.app.library.validators.LibraryValidator;
import com.practice.meesho.app.library.validators.UserQuotaValidator;

import java.util.List;

//@SpringBootApplication

/**
 * Lirabry has Users
 * Library has Books
 * User can reserver Books
 * <p>
 * User
 */
public class AppApplication {

    public static void main(String[] args) {

        LibraryValidator libraryValidator = new UserQuotaValidator();
        UserService userService = new UserService(new UserRepository());
        BookService bookService = new BookService(new BookRecordRepository(), libraryValidator);
        LibraryService libraryService = new LibraryService(
                bookService,
                userService,
                libraryValidator
        );

        bookService.addBook("Book of Dreams", 2);
        bookService.addBook("Book of Life1", 3);
        bookService.addBook("Book of Life Vol2", 6);
        bookService.addBook("CS Intro", 4);

        System.out.println("Book Added");
        try {
            userService.registerUser("Amit");
            userService.registerUser("CHAND");
            userService.registerUser("Naveen");
            userService.registerUser("Naveen");
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reserve A book");

        System.out.println(libraryService.reserveBook("Amit", "Book of Life1"));
        System.out.println(libraryService.reserveBook("Amit", "Book of Life1"));
        System.out.println(libraryService.reserveBook("Amit", "Book of Life Vol2"));
        System.out.println(libraryService.returnBook("Amit", "CS Intro"));

        System.out.println(libraryService.reserveBook("Amit", "CS Intro"));

        System.out.println(libraryService.returnBook("Amit", "Book of Life1"));
        System.out.println("7. " + libraryService.reserveBook("Amit", "CS Intro"));
        System.out.println(libraryService.reserveBook("Naveen", "Book of Dreams"));
        System.out.println(libraryService.reserveBook("CHAND", "Book of Dreams"));
        try {
            List<User> users = libraryService.usersWithBook("Book of Dreams");
            System.out.print("Book Reserved by -> ");
            for (User user : users) {
                System.out.print(user.getUserName() + " | ");
            }
        } catch (LibraryException e) {
            throw new RuntimeException(e);
        }

    }


}
