//package com.practice.amit.facebookoops.repos;
//
//import com.practice.amit.facebookoops.users.activity.Message;
//import com.practice.amit.facebookoops.users.activity.Post;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MessageRepo {
//
//    private Map<String, Map<String,List<Message>>> messages;
//
//    public MessageRepo(Map<String, Map<String, List<Message>>> messages) {
//        this.messages = messages;
//    }
//
//    public String addMessage(Post post) {
//        String key = UUID.randomUUID().toString();
//        post.setId(key);
//        posts.put(key, post);
//
//        List<Post> posts = postsByUser.getOrDefault(post.getOwner(), new ArrayList<>());
//        posts.add(post);
//        postsByUser.put(post.getOwner(), posts);
//
//        return key;
//    }
//
//    public Post getMessages(String userId1, String userId2) {
//        return posts.get(id);
//    }
//
//    public List<Post> getPostByUser(String user) {
//        return postsByUser.get(user);
//    }
//}
