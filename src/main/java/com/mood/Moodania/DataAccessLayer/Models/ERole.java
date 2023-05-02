package com.mood.Moodania.DataAccessLayer.Models;

public enum ERole {
    Default,
    Premium,
    Admin;

    @Override
    public String toString() {
        return this.name();
    }
}
