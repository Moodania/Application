package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.DataAccessLayer.Repositories.AccountRepository;
import com.mood.Moodania.DataAccessLayer.Repositories.UserRepository;
import com.mood.Moodania.Presentation.Models.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import com.mood.Moodania.ServiceLayer.Services.Interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements AccountServiceInterface {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AccountDto logIn(LogInUserAccountModel logInModel){
        //TODO()

        return Mapper.toAccountDto(logInModel,null,null,null);
    }
    @Override
    public AccountDto signUp(SignUpUserAccountModel model) {
        //TODO()
        return Mapper.toAccountDto(model,null,null);
    }

}
