package com.driverHub.core.service;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;

public interface TelegramBotService {
    void createEvent();

    void sendMessage(Long receiverId, String messageText);

    void sendMessageWithKeyboard(Long receiverId, String messageText, InlineKeyboardButton... keyboardButtons);

    void registrateClient(Long telegramId, String name, String phone);

    void registrateDriver(Long telegramId, String name, String phone, String car);
}
