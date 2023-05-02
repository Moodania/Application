package com.mood.Moodania.ServiceLayer.Mapping;


import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import com.mood.Moodania.DataAccessLayer.Entities.RoleEntity;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Dto.RoleDto;

public class Mapper {

    public static AccountDto toAccountDto(AccountEntity account) {
        var user = account.getUser();
        return new AccountDto(account.getId(), user.getId(), user.getUsername(), account.getEmail(), account.getRole().getEName().toString());
    }

    public static RoleDto toRoleDto(RoleEntity role) {
        return new RoleDto(role.getId(), role.getEName().toString());
    }
}
