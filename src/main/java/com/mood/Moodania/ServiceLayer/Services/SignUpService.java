package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.SignUpDto;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    public SignUpDto signUp(SignUpUserAccountModel model) {
        //TODO()
        return Mapper.toSignUpDto(model,null,null);
    }
}
