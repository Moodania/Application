package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.LogInDto;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    public LogInDto LogIn(LogInUserAccountModel logInModel){
        //TODO()
        return Mapper.toLogInDto(logInModel,null,null,null);
    }
}
