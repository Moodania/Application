package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Nonnull
    private String username;

    @Nonnull
    private LocalDate birthday;
    @Nonnull
    private String region;

    private String picturePath;
    @Nonnull
    private String gender;


    public UserEntity() {}

    public UserEntity(@Nonnull String username, @Nonnull LocalDate birthday, @Nonnull String region) {
        this.region = region;
        this.username = username;
        this.birthday = birthday;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@Nonnull String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(@Nonnull String region) { this.region = region; }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getGender() { return gender; }

    public void setGender(@Nonnull String gender) { this.gender = gender; }
}
