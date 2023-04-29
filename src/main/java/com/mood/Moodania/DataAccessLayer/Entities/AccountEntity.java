package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Nonnull private String email;
    @Nonnull private String password;
    @Nonnull private LocalDate registrationDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    public AccountEntity() {}

    public AccountEntity(@Nonnull String email, @Nonnull String password, @Nonnull LocalDate registrationDate, @Nonnull UserEntity user) {
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(@Nonnull UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(@Nonnull LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(@Nonnull UserEntity user) {
        this.user = user;
    }
}
