package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.DataAccessLayer.Entities.*;
import com.mood.Moodania.DataAccessLayer.Repositories.*;
import com.mood.Moodania.ServiceLayer.Dto.*;
import com.mood.Moodania.ServiceLayer.Exceptions.ChatNotFoundException;
import com.mood.Moodania.ServiceLayer.Exceptions.MessageNotFoundException;
import com.mood.Moodania.ServiceLayer.Exceptions.SenderNotFoundException;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import com.mood.Moodania.ServiceLayer.Services.Interfaces.ChattingServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatService implements ChattingServiceInterface {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(MessageRepository messageRepository, UserRepository userRepository, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
    }

    @Override
    public MessageDto addMessageToChat(UUID chatId, UUID senderId, TextMessage message) throws Exception{
        Optional<ChatEntity> chat = chatRepository.findById(chatId);
        var sender = userRepository.findById(senderId);
        if (sender.isEmpty())
            throw new SenderNotFoundException();
        if (chat.isEmpty())
            throw new ChatNotFoundException();
        MessageEntity newMessage = new MessageEntity(chat.get(),sender.get(),message.toString());
        chat.get().getMessages().add(newMessage);
        return Mapper.toMessageDto(newMessage);
    }

    @Override
    public ChatDto createChat() {
        return null;
    }

    @Override
    public ArrayList<MessageDto> getChatMessages(UUID chatID) {
        var messages = messageRepository.findByChatId(chatID);
        return (ArrayList<MessageDto>) messages.stream().map(Mapper::toMessageDto).toList();
    }

    @Override
    public void finishCurrentChat(UUID chatID) {

    }

    @Override
    public void deleteMessageById(UUID messageId) {
        messageRepository.deleteById(messageId);
    }

    @Override
    public void changeMessageById(UUID messageId, TextMessage newMessage) throws MessageNotFoundException {
        var message = messageRepository.findById(messageId);
        if (message.isEmpty())
            throw new MessageNotFoundException();
        message.get().setMessage(newMessage.toString());

    }
}
