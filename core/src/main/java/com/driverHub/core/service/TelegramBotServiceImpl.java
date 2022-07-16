package com.driverHub.core.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendLocation;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotServiceImpl implements TelegramBotService {
    private final TelegramBot telegramBot;
    private final ClientService clientService;
    private final TaxiDriverService taxiDriverService;

    @Override
    public void createEvent() {
    }

    @Override
    public void sendMessage(Long receiverId, String messageText) {
        SendMessage request = new SendMessage(receiverId, messageText)
                .parseMode(ParseMode.HTML);
        telegramBot.execute(request);
    }

    @Override
    public void sendMessageWithKeyboard(Long receiverId, String messageText, Keyboard keyboard) {
        SendMessage request = new SendMessage(receiverId, messageText)
                .parseMode(ParseMode.HTML)
                .replyMarkup(keyboard);
        telegramBot.execute(request);
    }

    @Override
    public void sendLocation(Long receiverId, float latitude, float longitude) {
        SendLocation request = new SendLocation(receiverId, latitude, longitude);
        telegramBot.execute(request);
    }

    @Override
    public void registrateClient(Long telegramId, String name, String phone) {
        clientService.createAndSaveClient(telegramId, name, phone);
    }

    @Override
    public void registrateDriver(Long telegramId, String name, String phone, String car) {
        taxiDriverService.createAndSaveTaxiDriver(telegramId, name, phone, car);
    }

}
