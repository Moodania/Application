package com.mood.Moodania.ServiceLayer.Services.Implementations;

import com.mood.Moodania.DataAccessLayer.Entities.AccountEntity;
import com.mood.Moodania.DataAccessLayer.Entities.RoleEntity;
import com.mood.Moodania.DataAccessLayer.Entities.StatisticsEntity;
import com.mood.Moodania.DataAccessLayer.Entities.UserEntity;
import com.mood.Moodania.DataAccessLayer.Models.ERole;
import com.mood.Moodania.DataAccessLayer.Repositories.AccountRepository;
import com.mood.Moodania.DataAccessLayer.Repositories.RoleRepository;
import com.mood.Moodania.DataAccessLayer.Repositories.StatisticsRepository;
import com.mood.Moodania.DataAccessLayer.Repositories.UserRepository;
import com.mood.Moodania.ServiceLayer.Dto.AccountDto;
import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;
import com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions.InvalidPasswordOrUsernameException;
import com.mood.Moodania.ServiceLayer.Mapping.Mapper;
import com.mood.Moodania.ServiceLayer.Services.AuthenticationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthenticationService implements AuthenticationServiceInterface, UserDetailsService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final StatisticsRepository statisticsRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthenticationService(AccountRepository accountRepository, UserRepository userRepository, StatisticsRepository statisticsRepository, RoleRepository roleRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.statisticsRepository = statisticsRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public AccountDto logIn(String email, String password) throws InvalidPasswordOrUsernameException {
        AccountEntity account = accountRepository.findAccountEntityByEmail(email)
                .orElseThrow(() -> new InvalidPasswordOrUsernameException());
        if (!account.getPassword().equals(password))
            throw new InvalidPasswordOrUsernameException();

        return Mapper.toAccountDto(account);
    }

    @Override
    public AccountDto signUp(String email, String username, String password, String region, LocalDate birthday)
            throws EmailAlreadyExistException {
        if (accountRepository.findAccountEntityByEmail(email).isPresent())
            throw new EmailAlreadyExistException(email);


        var user = new UserEntity(username, birthday, region);

        RoleEntity role = roleRepository.findByName(ERole.ROLE_DEFAULT);
        var account = new AccountEntity(email, password, LocalDate.now(), user, role);

        var statistics = new StatisticsEntity(user);

        userRepository.save(user);
        statisticsRepository.save(statistics);
        accountRepository.save(account);

        return Mapper.toAccountDto(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findAccountEntityByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email " + username + " not found exception"));
    }
}