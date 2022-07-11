package com.driverHub.core.service;

public interface TelegramBotService {
    void createEvent();
    void sendMessage(String receiverId, String messageText);
    void subscribeOnAllTelegramBotEvents();
}
