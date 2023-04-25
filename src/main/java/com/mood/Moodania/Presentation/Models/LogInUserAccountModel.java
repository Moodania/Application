package com.mood.Moodania.Presentation.Models;

import java.util.UUID;


public class LogInUserAccountModel {
    public String email;
    public String password;

    public LogInUserAccountModel(String email, String password) {

        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "LogInUserAccountModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
