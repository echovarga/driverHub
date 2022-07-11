package com.driverHub.core.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotServiceImpl implements TelegramBotService {
    private final TelegramBot telegramBot;
    private final ClientService clientService;
    private final TaxiDriverService taxiDriverService;

    @PostConstruct
    private void init() {
        subscribeOnAllTelegramBotEvents();
    }

    @Override
    public void createEvent() {
    }

    @Override
    public void sendMessage(String receiverId, String messageText) {
        SendMessage request = new SendMessage(receiverId, messageText)
                .parseMode(ParseMode.HTML);
        telegramBot.execute(request);
    }

    @Override
    public void sendMessageWithKeyboard(String receiverId, String messageText, InlineKeyboardButton... keyboardButtons) {
        SendMessage request = new SendMessage(receiverId, messageText)
                .parseMode(ParseMode.HTML);
        Keyboard keyboard = new InlineKeyboardMarkup(keyboardButtons);
        request.replyMarkup(keyboard);
        telegramBot.execute(request);
    }

    @Override
    public void subscribeOnAllTelegramBotEvents() {
        telegramBot.setUpdatesListener(createUpdatesListener());
    }

    @Override
    public void registrateClient(String name, String phone) {
        clientService.createAndSaveClient(name, phone);
    }

    @Override
    public void registrateDriver(String name, String phone, String car) {
        taxiDriverService.createAndSaveTaxiDriver(name, phone, car);
    }

    private UpdatesListener createUpdatesListener() {
        return updates -> {
            // process updates
            log.info("updates here");
            updates.forEach(update -> log.info(update.toString()));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        };
    }
}
