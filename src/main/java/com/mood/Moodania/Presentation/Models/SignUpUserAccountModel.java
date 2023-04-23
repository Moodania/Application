package com.mood.Moodania.Presentation.Models;

import java.util.ArrayList;

public class SignUpUserAccountModel {
    private String username;
    private String region;
    private String age;
    private ArrayList<String> interests;
    private String email;
    private String password;

    public SignUpUserAccountModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public SignUpUserAccountModel(String username, String region, String age, ArrayList<String> interests, String email, String password) {
        this.username = username;
        this.region = region;
        this.age = age;
        this.interests = interests;
        this.email = email;
        this.password = password;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

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
