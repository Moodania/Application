package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;
import com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions.InvalidPasswordOrUsernameException;

import java.time.LocalDate;

public interface AuthenticationServiceInterface {
    AccountDto logIn(String email, String password) throws InvalidPasswordOrUsernameException;
    AccountDto signUp(String email, String username, String password, String region, LocalDate birthday)
            throws EmailAlreadyExistException;
    AccountDto findAccountByEmail(String email);
}
