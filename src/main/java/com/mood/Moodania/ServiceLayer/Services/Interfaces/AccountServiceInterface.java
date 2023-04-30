package com.mood.Moodania.ServiceLayer.Services.Interfaces;

import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;

public interface AccountServiceInterface {
    public AccountDto logIn(LogInUserAccountModel model);
    public AccountDto signUp(SignUpUserAccountModel model);
}
