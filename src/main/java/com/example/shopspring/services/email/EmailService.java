package com.example.shopspring.services.email;


import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("jamoncheryev1@gmail.com");
        mailSender.setPassword("gplyaqayvdsgkpho");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        emailSender = mailSender;
    }

    @Async
    public void sendEmailMessage(Object o) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("shop.spring@app.com");
        message.setTo("jamoncheryev1@gmail.com");
        message.setSubject("Created new object in database");
        message.setText("Object: " + o.toString());
        emailSender.send(message);
    }
}
