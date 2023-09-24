package org.interview.my.app.model;

public class CaseLocation {
    String city;
    String state;
    String country;

    public CaseLocation(String country, String state,String city ) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
