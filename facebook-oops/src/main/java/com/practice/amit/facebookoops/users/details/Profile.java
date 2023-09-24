package com.practice.amit.facebookoops.users.details;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Profile {
    private String summary;
    private String experiences;
    private String educations;
    private String skills;
    private String accomplishments;
    private String recommendations;
    private String stats;

    public void addExperience(String experience){
    }

    public void addEducation(String education) {
    }

    public void addSkill(String skill) {
    }

    public void addAccomplishment(String accomplishment){}

    public void addRecommendation(String recommendation){}
}
