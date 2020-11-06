package com.example.mail.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class EmailService {

    private final String receiver = "decbartek@gmail.com";

    @Value("${spring.mail.username}")
    private String sender;
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @After("@annotation(com.example.mail.service.annotation.EmailAspect)")
    public void sendNotification() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(receiver);
        mailMessage.setFrom(sender);
        mailMessage.setSubject("Notification from Spring app");
        mailMessage.setText("Somebody has added a new movie");

        javaMailSender.send(mailMessage);
    }
}
