package com.practice.amit.facebookoops.relations;

import com.practice.amit.facebookoops.users.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class Session {
    private String status;
    private User user;
    private Instant validTs;
}
