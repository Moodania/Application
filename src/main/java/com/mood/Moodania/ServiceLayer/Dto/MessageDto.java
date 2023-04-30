package com.mood.Moodania.ServiceLayer.Dto;

import com.mood.Moodania.DataAccessLayer.Entities.ChatEntity;
import com.mood.Moodania.DataAccessLayer.Entities.UserEntity;

import java.util.UUID;

public record MessageDto(UUID messageId, UUID chatId, UUID senderId, String message) {
    }

