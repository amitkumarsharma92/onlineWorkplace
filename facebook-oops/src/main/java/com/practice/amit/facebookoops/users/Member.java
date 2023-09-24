package com.practice.amit.facebookoops.users;
import com.practice.amit.facebookoops.users.activity.Message;
import com.practice.amit.facebookoops.users.activity.Post;
import com.practice.amit.facebookoops.users.details.Profile;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class Member {
    private LocalDate joiningDate;
    private String headline;
    private List<Member> suggestions;
    private List<Member> memberFollows;
    private List<Member> memberConnections;
    private Profile profile;

    public void sendMessage(Message message){
    }

    public void createPost(Post post){
    }

    public void blockUser(String userId){
    }

    public void unBlockUser(String userId){
    }


}

