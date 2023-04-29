package com.mood.Moodania.ServiceLayer.Exceptions.AlreadyExistExceptions;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException(String email) {
        super("Email " + email + " already exist");
    }
}
