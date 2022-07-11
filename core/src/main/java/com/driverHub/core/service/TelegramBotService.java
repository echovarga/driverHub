package com.driverHub.core.service;

import com.pengrad.telegrambot.model.request.Keyboard;

public interface TelegramBotService {
    void createEvent();

    void sendMessage(Long receiverId, String messageText);

    void sendMessageWithKeyboard(Long receiverId, String messageText, Keyboard keyboard);

    void sendLocationWithKeyboard(Long receiverId, float latitude, float longitude);

    void registrateClient(Long telegramId, String name, String phone);

    void registrateDriver(Long telegramId, String name, String phone, String car);
}
