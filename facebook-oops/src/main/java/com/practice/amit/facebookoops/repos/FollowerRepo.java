package com.practice.amit.facebookoops.repos;

import com.practice.amit.facebookoops.users.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class FollowerRepo {

    Map<String, Set<User>> followTable;

    public boolean addFollow(User follower, User user) {
        Set<User> followedUsers = followTable.getOrDefault(follower.getAccout().getId(), new HashSet<>());
        followTable.put(follower.getAccout().getId(), followedUsers);
        return followedUsers.add(user);
    }

    public Set<User> getFollowedUserList(User follower) {
        return followTable.get(follower.getUserId());
    }

}
