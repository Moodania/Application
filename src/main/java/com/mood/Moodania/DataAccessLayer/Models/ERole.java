package com.mood.Moodania.DataAccessLayer.Models;

public enum ERole {
    ROLE_DEFAULT,
    ROLE_PREMIUM,
    ROLE_ADMIN;


    @Override
    public String toString() {
        return this.name();
    }
}
