package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "chats")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @Nonnull private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnerId", referencedColumnName = "id", nullable = false)
    @Nonnull private UserEntity partner;

    private int userRate;
    private int partnerRate;
    private int userMessagesCount;
    private int partnerMessagesCount;

    @Nonnull private String sameInterests;

    @Nonnull private LocalDateTime meetDate;
    private long chatTimeSeconds;

    public ChatEntity(@Nonnull UserEntity user, @Nonnull UserEntity partner, @Nonnull String sameInterests, @Nonnull LocalDateTime meetDate) {
        this.user = user;
        this.partner = partner;
        this.sameInterests = sameInterests;
        this.meetDate = meetDate;
    }

    public ChatEntity() {
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

    public void setUser(@Nonnull UserEntity user) {
        this.user = user;
    }

    public UserEntity getPartner() {
        return partner;
    }

    public void setPartner(@Nonnull UserEntity partner) {
        this.partner = partner;
    }

    public int getUserRate() {
        return userRate;
    }

    public void setUserRate(int userRate) {
        this.userRate = userRate;
    }

    public int getPartnerRate() {
        return partnerRate;
    }

    public void setPartnerRate(int partnerRate) {
        this.partnerRate = partnerRate;
    }

    public int getUserMessagesCount() {
        return userMessagesCount;
    }

    public void setUserMessagesCount(int userMessagesCount) {
        this.userMessagesCount = userMessagesCount;
    }

    public int getPartnerMessagesCount() {
        return partnerMessagesCount;
    }

    public void setPartnerMessagesCount(int partnerMessagesCount) {
        this.partnerMessagesCount = partnerMessagesCount;
    }

    public String getSameInterests() {
        return sameInterests;
    }

    public void setSameInterests(@Nonnull String sameInterests) {
        this.sameInterests = sameInterests;
    }

    public LocalDateTime getMeetDate() {
        return meetDate;
    }

    public void setMeetDate(LocalDateTime meetDate) {
        this.meetDate = meetDate;
    }

    public long getChatTimeSeconds() {
        return chatTimeSeconds;
    }

    public void setChatTimeSeconds(long chatTimeSeconds) {
        this.chatTimeSeconds = chatTimeSeconds;
    }
}
