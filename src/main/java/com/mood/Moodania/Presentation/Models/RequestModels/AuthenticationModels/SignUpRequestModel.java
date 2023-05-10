package com.mood.Moodania.Presentation.Models.RequestModels.AuthenticationModels;

import java.time.LocalDate;

public class    SignUpRequestModel {
    private String email;
    private String username;
    private String password;
    private LocalDate birthday;
    private String region;
    // private ArrayList<String> interests;

    public SignUpRequestModel(String email, String username, String password, LocalDate birthday, String region) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.region = region;
        //this.interests = interests;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /*public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
