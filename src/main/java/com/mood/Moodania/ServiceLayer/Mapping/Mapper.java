package com.mood.Moodania.ServiceLayer.Mapping;


import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import com.mood.Moodania.Presentation.Models.AccountModels.LogInUserAccountModel;
import com.mood.Moodania.Presentation.Models.AccountModels.SignUpUserAccountModel;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;

import java.util.UUID;

public class Mapper {

    public static AccountDto toAccountDto(AccountEntity account, String username) {
        return new AccountDto(account.getId(), account.getUser().getId(), username, account.getEmail());
    }
}
