package com.mood.Moodania.DataAccessLayer.Entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Statistics")
public class StatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Nonnull private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @Nonnull private UserEntity user;

    private double avgScore;
    private double likePercentage;
    private double dislikePercentage;
    private long totalMessages;
    private int totalScore;
    private int totalChats;
    private int totalLikesToUser;
    private int totalDislikesToUser;
    private int totalLikesFromUser;
    private int totalDislikesFromUser;

    public StatisticsEntity() {

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

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public double getLikePercentage() {
        return likePercentage;
    }

    public void setLikePercentage(double likePercentage) {
        this.likePercentage = likePercentage;
    }

    public double getDislikePercentage() {
        return dislikePercentage;
    }

    public void setDislikePercentage(double dislikePercentage) {
        this.dislikePercentage = dislikePercentage;
    }

    public long getTotalMessages() {
        return totalMessages;
    }

    public void setTotalMessages(long totalMessages) {
        this.totalMessages = totalMessages;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalChats() {
        return totalChats;
    }

    public void setTotalChats(int totalChats) {
        this.totalChats = totalChats;
    }

    public int getTotalLikesToUser() {
        return totalLikesToUser;
    }

    public void setTotalLikesToUser(int totalLikesToUser) {
        this.totalLikesToUser = totalLikesToUser;
    }

    public int getTotalDislikesToUser() {
        return totalDislikesToUser;
    }

    public void setTotalDislikesToUser(int totalDislikesToUser) {
        this.totalDislikesToUser = totalDislikesToUser;
    }

    public int getTotalLikesFromUser() {
        return totalLikesFromUser;
    }

    public void setTotalLikesFromUser(int totalLikesFromUser) {
        this.totalLikesFromUser = totalLikesFromUser;
    }

    public int getTotalDislikesFromUser() {
        return totalDislikesFromUser;
    }

    public void setTotalDislikesFromUser(int totalDislikesFromUser) {
        this.totalDislikesFromUser = totalDislikesFromUser;
    }
}
