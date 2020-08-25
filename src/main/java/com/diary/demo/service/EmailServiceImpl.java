package com.diary.demo.service;

import com.diary.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender sender;

    @Override
    public void sendMessageToEmail(Message message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(message.getEmail());
        mailMessage.setFrom(message.getUsername());
        mailMessage.setSubject(message.getUsername());
        mailMessage.setText(message.getMsg());
        sender.send(mailMessage);
    }
}