package com.practice.meesho.app.library.services;

import com.practice.meesho.app.library.exeptions.LibraryException;
import com.practice.meesho.app.library.models.Book;
import com.practice.meesho.app.library.models.User;
import com.practice.meesho.app.library.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String userName) throws LibraryException {
        User newuser = new User(userName);
        if (!userRepository.insert(newuser)) throw LibraryException.userAlreadyExists(userName);
    }

    public void reserveBook(String userName, Book book) throws LibraryException {
        User registeredUser = getUser(userName);
        registeredUser.addBook(book);
    }

    public User getUser(String userName) throws LibraryException {
        User registeredUser = userRepository.getById(userName);
        if (registeredUser == null) throw LibraryException.userDoNotExists(userName);

        return registeredUser;
    }
}
