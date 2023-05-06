package com.mood.Moodania.Presentation.Models.RequestModels.AuthenticationModels;


public class LogInRequestModel {
    private String email;
    private String password;

    public LogInRequestModel(String email, String password) {

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
}
