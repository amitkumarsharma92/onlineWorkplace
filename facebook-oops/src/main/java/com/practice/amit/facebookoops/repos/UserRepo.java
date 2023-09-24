package com.practice.amit.facebookoops.repos;

import com.practice.amit.facebookoops.users.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class UserRepo {

    Map<String, User> userRecords;

    public String addUser(User user) {
        String key = UUID.randomUUID().toString();
        userRecords.put(key, user);
        return key;
    }

    public User getUser(String id) {
        return userRecords.get(id);
    }
}
