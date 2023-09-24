package com.practice.amit.facebookoops.users.activity;


import com.practice.amit.facebookoops.users.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
public class Content {
    private String text;
    private List<Object> media;
}
