package com.diary.demo.listener;

import com.diary.demo.entity.Message;
import com.diary.demo.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "#{autoDeletedQueue.name}")
public class MessageReceiver {
    @Autowired
    EmailService emailService;

    @RabbitHandler
    public void receive(Message message) {
        System.out.println(message);
        emailService.sendMessageToEmail(message);
    }
}