package com.mood.Moodania.Presentation.Exceptions;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException() {
        super("Token is expired or invalid");
    }
}
