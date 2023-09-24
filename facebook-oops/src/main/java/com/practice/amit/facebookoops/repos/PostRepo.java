package com.practice.amit.facebookoops.repos;

import com.practice.amit.facebookoops.users.User;
import com.practice.amit.facebookoops.users.activity.Post;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PostRepo {

    Map<String, Post> posts;

    Map<String, List<Post>> postsByUser;

    public String addPost(Post post) {
        String key = UUID.randomUUID().toString();
        post.setId(key);
        posts.put(key, post);

        List<Post> posts = postsByUser.getOrDefault(post.getOwner(), new ArrayList<>());
        posts.add(post);
        postsByUser.put(post.getOwner().getUserId(), posts);

        return key;
    }

    public Post getPost(String id) {
        return posts.get(id);
    }

    public String delete(String id) {
        Post tobeDelete = posts.remove(id);
        if (tobeDelete != null) {
            List<Post> allPosts = postsByUser.get(tobeDelete.getOwner().getUserId());
            allPosts.remove(tobeDelete);
            return tobeDelete.getId();
        }
        return null;
    }

    public List<Post> getPostByUser(User user) {
        return postsByUser.get(user.getUserId());
    }

    public List<Post> getPostsByUsers(Set<User> users) {
        List<Post> result = new ArrayList<>();
        for (User user : users) {
            result.addAll(getPostByUser(user));
        }
        Collections.sort(result, (u1, u2) ->
                u1.getCreateTs().compareTo(u2.getCreateTs())
        );
        return result;
    }
}
