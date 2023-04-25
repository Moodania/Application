package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.UUID;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity() {
    }

    public UserEntity(UUID id) {
        this.id = id;
    }
}
