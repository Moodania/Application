package com.mood.Moodania.Presentation.config;

import com.mood.Moodania.DataAccessLayer.Repositories.AccountRepository;
import com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions.InvalidPasswordOrUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class ApplicationConfiguration {

    private final AccountRepository accountRepository;

    @Autowired
    public ApplicationConfiguration(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Bean
    public UserDetailsService userDetailsService () {
        return username -> accountRepository.findAccountEntityByEmail(username)
                .orElseThrow(InvalidPasswordOrUsernameException::new);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        /*authenticationProvider.setPasswordEncoder();*/
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
