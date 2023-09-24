package com.practice.meesho.app.library.repository;

import com.practice.meesho.app.library.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository implements Repository<User> {

    private Map<String, User> userTable = new HashMap<>();

    @Override
    public User getById(String userName) {
        return userTable.get(userName);
    }

    public boolean insert(User user) {
        if (userTable.containsKey(user.getUserName())) return false;
        userTable.put(user.getUserName(), user);
        return true;
    }

}
