package com.mood.Moodania.ServiceLayer.Mapping;


import com.mood.Moodania.DataAccessLayer.Entities.MessageEntity;
import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Dto.MessageDto;

import java.util.UUID;

public class Mapper {

    public static AccountDto toAccountDto(LogInUserAccountModel model,String username, UUID userId, UUID accountId){
        return new AccountDto(username, model.getEmail(), userId, accountId);
    }
    public static AccountDto toAccountDto(SignUpUserAccountModel model, UUID userId, UUID accountId){
        return new AccountDto(model.getUsername(), model.getEmail(),userId,accountId);
    }

    public static MessageDto toMessageDto(MessageEntity newMessage) {
        return new MessageDto(newMessage.getId(), newMessage.getChat().getId(), newMessage.getSender().getId(), newMessage.getMessage());
    }
}
