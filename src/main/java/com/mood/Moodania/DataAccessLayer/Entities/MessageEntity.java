package com.mood.Moodania.DataAccessLayer.Entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.UUID;

@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "chatId", referencedColumnName = "id", nullable = false)
    @Nonnull
    private ChatEntity chat;

    @OneToOne
    @JoinColumn(name = "senderId", referencedColumnName = "id", nullable = false)
    @Nonnull
    private UserEntity sender;

    @Nonnull
    private String message;


    public MessageEntity() {
    }

    public MessageEntity( @Nonnull ChatEntity chat, @Nonnull UserEntity sender, @Nonnull String message) {
        this.chat = chat;
        this.sender = sender;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Nonnull
    public ChatEntity getChat() {
        return chat;
    }

    public void setChat(@Nonnull ChatEntity chat) {
        this.chat = chat;
    }

    @Nonnull
    public UserEntity getSender() {
        return sender;
    }

    public void setSender(@Nonnull UserEntity sender) {
        this.sender = sender;
    }

    @Nonnull
    public String getMessage() {
        return message;
    }

    public void setMessage(@Nonnull String message) {
        this.message = message;
    }

}
