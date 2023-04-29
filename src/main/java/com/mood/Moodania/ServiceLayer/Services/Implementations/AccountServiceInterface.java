package com.mood.Moodania.ServiceLayer.Services.Implementations;

import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface AccountServiceInterface {
    public AccountDto logIn();
    public AccountDto signUp(String email, String username, String password, String region, LocalDate birthday)
            throws EmailAlreadyExistException;
}
