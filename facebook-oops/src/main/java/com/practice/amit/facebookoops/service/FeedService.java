package com.practice.amit.facebookoops.service;

import com.practice.amit.facebookoops.relations.Session;
import com.practice.amit.facebookoops.repos.FollowerRepo;
import com.practice.amit.facebookoops.repos.PostRepo;
import com.practice.amit.facebookoops.users.User;
import com.practice.amit.facebookoops.users.activity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FeedService {

    @Autowired
    private FollowerRepo followerRepo;

    @Autowired
    private PostRepo postRepo;

    public List<Post> getHomeFeed(Session session) {
        User currentUser = session.getUser();
        Set<User> followedList = followerRepo.getFollowedUserList(currentUser);

        List<Post> post = postRepo.getPostsByUsers(followedList);
        return post;
    }
}
