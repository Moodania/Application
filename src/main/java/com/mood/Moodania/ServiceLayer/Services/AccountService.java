package com.mood.Moodania.ServiceLayer.Services;

import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import com.mood.Moodania.DataAccessLayer.Entities.UserEntity;
import com.mood.Moodania.DataAccessLayer.Repositories.AccountRepository;
import com.mood.Moodania.DataAccessLayer.Repositories.UserRepository;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import com.mood.Moodania.ServiceLayer.Services.Implementations.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    public AccountDto logIn() {
        throw new RuntimeException();
    }

    @Override
    public AccountDto signUp(String email, String username, String password, String region, LocalDate birthday)
            throws EmailAlreadyExistException {
        if (accountRepository.findAccountEntityByEmail(email) != null)
            throw new EmailAlreadyExistException(email);

        var user = new UserEntity(username, birthday, region);
        var account = new AccountEntity(email, password, LocalDate.now(), user);

        userRepository.save(user);
        accountRepository.save(account);

        return Mapper.toAccountDto(account, username);
    }
}