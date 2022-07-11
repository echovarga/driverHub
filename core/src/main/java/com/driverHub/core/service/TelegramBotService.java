package com.driverHub.core.service;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;

public interface TelegramBotService {
    void createEvent();

    void sendMessage(Long receiverId, String messageText);

    void sendMessageWithKeyboard(String receiverId, String messageText, InlineKeyboardButton... keyboardButtons);

    void registrateClient(String name, String phone);

    void registrateDriver(String name, String phone, String car);
}
