package com.practice.amit.facebookoops.service;

import com.practice.amit.facebookoops.relations.Session;
import com.practice.amit.facebookoops.repos.FollowerRepo;
import com.practice.amit.facebookoops.repos.PostRepo;
import com.practice.amit.facebookoops.repos.UserRepo;
import com.practice.amit.facebookoops.users.User;
import com.practice.amit.facebookoops.users.activity.Content;
import com.practice.amit.facebookoops.users.activity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FollowerRepo followerRepo;

    public String addPost(Session session, Content content) {
        User currentUser = session.getUser();
        return postRepo.addPost(new Post(content, currentUser, Instant.now()));
    }

    public String deletePost(Session session, String postId) {
        User currentUser = session.getUser();
        return postRepo.delete(postId);
    }

    public boolean follow(Session session, String userId) {
        User currentUser = session.getUser();
        User user = userRepo.getUser(userId);
        return followerRepo.addFollow(currentUser, user);
    }
}
