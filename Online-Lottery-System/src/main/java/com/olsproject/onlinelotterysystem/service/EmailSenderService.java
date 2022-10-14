package com.olsproject.onlinelotterysystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toMail, String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("jonsnowdracarysgot@gmail.com");
        message.setTo("shrinathlhaykar@gmail.com");
        message.setText(body);
        message.setSubject("Congratulations");
        mailSender.send(message);
        System.out.println("Mail Sent");
    }
}
