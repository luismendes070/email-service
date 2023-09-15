package com.github.luismendes070.emailservice.core;

import com.github.luismendes070.emailservice.core.exceptions.EmailServiceException;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body) throws EmailServiceException;

}
