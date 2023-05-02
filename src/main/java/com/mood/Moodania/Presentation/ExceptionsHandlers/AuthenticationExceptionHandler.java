package com.mood.Moodania.Presentation.ExceptionsHandlers;

import com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions.EmailAlreadyExistException;
import com.mood.Moodania.ServiceLayer.Exceptions.InvalidExceptions.InvalidPasswordOrUsernameException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class AuthenticationExceptionHandler {
    @ExceptionHandler(InvalidPasswordOrUsernameException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> handleInvalidPasswordOrUsernameException(InvalidPasswordOrUsernameException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleEmailAlreadyExistException(EmailAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
