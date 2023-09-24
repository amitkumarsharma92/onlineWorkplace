package com.practice.amit.facebookoops.users.activity;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Setter
@Getter
public class Message {
    private String sent_to;
    private String  message_body;
    private String  media;
    private Instant createTs;
}
