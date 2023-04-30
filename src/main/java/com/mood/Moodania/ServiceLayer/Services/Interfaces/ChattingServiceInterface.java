package com.mood.Moodania.ServiceLayer.Services.Interfaces;

import com.mood.Moodania.ServiceLayer.Dto.ChatDto;
import com.mood.Moodania.ServiceLayer.Dto.MessageDto;
import com.mood.Moodania.ServiceLayer.Exceptions.MessageNotFoundException;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.UUID;

public interface ChattingServiceInterface {
    public MessageDto addMessageToChat(UUID chatId, UUID senderId, TextMessage message) throws Exception;
    public ChatDto createChat();
    public ArrayList<MessageDto> getChatMessages(UUID chatID);
    public void finishCurrentChat(UUID chatID);

    public void deleteMessageById(UUID messageId);
    void changeMessageById(UUID messageId, TextMessage newMessage) throws MessageNotFoundException;
}
