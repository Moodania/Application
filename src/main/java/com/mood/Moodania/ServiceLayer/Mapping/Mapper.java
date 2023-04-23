package com.mood.Moodania.ServiceLayer.Mapping;


import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.LogInDto;
import com.mood.Moodania.ServiceLayer.Dto.SignUpDto;

import java.util.UUID;

public class Mapper {

    public static LogInDto toLogInDto(LogInUserAccountModel model,String username, UUID userId, UUID accountId){
        return new LogInDto(username, model.getEmail(), userId, accountId);
    }
    public static SignUpDto toSignUpDto(SignUpUserAccountModel model, UUID userId, UUID accountId){
        return new SignUpDto(model.getUsername(), model.getEmail(),userId,accountId);
    }
}
