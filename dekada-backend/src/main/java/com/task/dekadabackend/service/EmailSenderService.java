package com.task.dekadabackend.service;

import com.task.dekadabackend.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSenderService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;

    private static final Logger log = LoggerFactory.getLogger(EmailSenderService.class);

    public EmailSenderService(SpringTemplateEngine templateEngine, JavaMailSender emailSender, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.emailSender = emailSender;
        this.javaMailSender = javaMailSender;
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void scheduledEmail() throws MessagingException {
        sendEmail(prepareEmail());
    }

    public void sendEmail(Email email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        Context context = new Context();
        context.setVariables(email.getProps());

        String html = templateEngine.process("email-template", context);

        helper.setTo(email.getMailTo());
        helper.setText(html, true);
        helper.setSubject(email.getSubject());
        helper.setFrom(email.getFrom());

        emailSender.send(message);
    }

    public void sendSimpleEmail(){
        log.info("SENDING... preparing to send email...");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("baraba333@gmail.com");
        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello,\nSpring Boot Email\n\nBest regards,\nPKB");
        log.info("Mail Sent Successfully...");
        javaMailSender.send(msg);
    }

    public Email prepareEmail() {
        log.info("SENDING... preparing to send email...");
        Email mail = new Email();
        mail.setFrom("testko.demo@gmail.com");  //replace with email sender
        mail.setMailTo("baraba333@gmail.com");  //replace with email receiver
        mail.setSubject("Email with Spring boot and thymeleaf template!");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", "Developer!");
        model.put("location", "Zagreb, Croatia");
        model.put("sign", "Java Backend Developer");
        model.put("message", lorem);
        model.put("title", title);
        mail.setProps(model);
        log.info("Mail Sent Successfully...");
        return mail;
    }

    String title = "Spring boot email template with Thymeleaf";
    String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore " +
            "et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
            "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fu" +
            "giat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mol" +
            "lit anim id est laborum.";

}

