package com.diary.demo.service;

import com.diary.demo.entity.Message;

public interface EmailService {
    void sendMessageToEmail(Message message);
}
