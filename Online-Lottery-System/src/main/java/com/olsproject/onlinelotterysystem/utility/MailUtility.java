package com.olsproject.onlinelotterysystem.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailUtility {
    @Autowired
    private JavaMailSender javaMailSender;

public void mailSender(String sendTo, String subject, String text){

}
}
