package com.practice.amit.facebookoops.users.activity;


import com.practice.amit.facebookoops.users.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class Post {
    private String id;
    private Content content;
    private int totalLikes;
    private int totalShare;
    private User owner;
    private Instant createTs;

    public Post(Content content, User owner, Instant createTs) {
        this.content = content;
        this.owner = owner;
        this.createTs = createTs;
    }
}
