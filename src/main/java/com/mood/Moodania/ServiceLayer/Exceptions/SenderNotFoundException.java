package com.mood.Moodania.ServiceLayer.Exceptions;

public class SenderNotFoundException extends Exception {
    public SenderNotFoundException() {
        super();
    }

    public SenderNotFoundException(String message) {
        super(message);
    }

    public SenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SenderNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SenderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
