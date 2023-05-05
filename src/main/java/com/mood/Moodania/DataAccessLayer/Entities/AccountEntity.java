package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Accounts",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "email")
        })

public class AccountEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Nonnull
    private String email;
    @Nonnull
    private String password;
    @Nonnull
    private LocalDate registrationDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
    private RoleEntity role;


    public AccountEntity() {}

    public AccountEntity(@Nonnull String email, @Nonnull String password, @Nonnull LocalDate registrationDate, @Nonnull UserEntity user, @NonNull RoleEntity role) {
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.user = user;
        this.role = role;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.getEName().name()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

}
