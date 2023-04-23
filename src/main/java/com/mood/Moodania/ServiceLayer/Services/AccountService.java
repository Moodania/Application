package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import com.mood.Moodania.ServiceLayer.Services.Implementations.AccountServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {
    public AccountDto logIn(LogInUserAccountModel logInModel){
        //TODO()
        return Mapper.toAccountDto(logInModel,null,null,null);
    }
    public AccountDto signUp(SignUpUserAccountModel model) {
        //TODO()
        return Mapper.toAccountDto(model,null,null);
    }
}
