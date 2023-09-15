package com.github.luismendes070.emailservice.core.exceptions;

public class EmailServiceException extends Throwable {
    public EmailServiceException(String message) {
        super(message);
    }

    public EmailServiceException(String message, Throwable cause){
        super(message, cause);
    }

}
