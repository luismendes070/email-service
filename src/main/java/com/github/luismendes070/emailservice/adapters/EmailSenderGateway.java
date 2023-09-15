package com.github.luismendes070.emailservice.adapters;

import com.github.luismendes070.emailservice.core.EmailSenderUseCase;

public interface EmailSenderGateway implements EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);
}
