package com.practice.amit.facebookoops.relations;

import com.practice.amit.facebookoops.users.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Follow {
    private User user;
    private User follower;

    public Follow(User user, User follower) {
        this.user = user;
        this.follower = follower;
    }
}
