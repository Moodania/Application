package com.mood.Moodania.Presentation.config;

import com.mood.Moodania.DataAccessLayer.Repositories.AccountRepository;
import com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions.InvalidPasswordOrUsernameException;
import com.mood.Moodania.ServiceLayer.Services.Implementations.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class ApplicationConfiguration {

    private final AuthenticationService authenticationService;

    @Autowired
    public ApplicationConfiguration(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

}
