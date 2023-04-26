package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "friends")
public class FriendsEntity {

    @Id
    private UUID id;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "firstUserId", referencedColumnName = "id")
    private UserEntity firstUser;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "secondUserId", referencedColumnName = "id")
    private UserEntity secondUser;

    public FriendsEntity(UserEntity firstUser, UserEntity secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }

    public FriendsEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(@Nonnull UserEntity firstUser) {
        this.firstUser = firstUser;
    }

    public UserEntity getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(@Nonnull UserEntity secondUser) {
        this.secondUser = secondUser;
    }
}
