package com.task.dekadabackend.controller;

import com.task.dekadabackend.service.EmailSenderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class SendEmailController {

    private final EmailSenderService emailService;

    private SendEmailController(EmailSenderService emailService){
        this.emailService = emailService;
    }

    @GetMapping("/send-simple-email")
    public void sendMail() {
        emailService.sendSimpleEmail();
    }

    @GetMapping("/send-template-email")
    public void sendThymeleafEmail() throws MessagingException {
        emailService.sendEmail(emailService.prepareEmail());
    }
}
