package com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class InvalidPasswordOrUsernameException extends UsernameNotFoundException {
    public InvalidPasswordOrUsernameException() {
        super("Invalid email or password");
    }
}