package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.UUID;

@Entity
public class AccountEntity {
    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    public AccountEntity() {
    }

    public AccountEntity(UUID id, UserEntity user) {
        this.id = id;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
