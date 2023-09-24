package com.practice.amit.facebookoops.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private Account accout;

    public String getUserId(){
        return accout.getId();
    }

}
