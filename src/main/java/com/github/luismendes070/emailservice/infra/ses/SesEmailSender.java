package com.github.luismendes070.emailservice.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.github.luismendes070.emailservice.adapters.EmailSenderGateway;
import com.github.luismendes070.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override
    public void sendEmail(String to, String subject, String body) throws EmailServiceException {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("machadoluismendes@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try{
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonSimpleEmailServiceException exception){
            throw new EmailServiceException("Failure while sending email.", exception);
        }

    }
}
