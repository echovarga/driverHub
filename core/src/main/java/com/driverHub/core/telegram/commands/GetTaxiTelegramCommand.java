package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TaxiDriverService;
import com.driverHub.core.service.TelegramBotService;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class GetTaxiTelegramCommand implements TelegramCommand {
    private final String commandText = "/getTaxi";
    private final String commandDescription = "Get Taxi Command";
    private final TaxiDriverService taxiDriverService;
    private final TelegramBotService telegramBotService;

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final String message = String.format("Hi, %s wants to ride!", update.message().from().firstName());
        final Long senderId = update.message().from().id();
        Keyboard inlineKeyboard = new ReplyKeyboardMarkup(
                new KeyboardButton("contact").requestContact(true),
                new KeyboardButton("location").requestLocation(true)
        ).resizeKeyboard(true);
        telegramBotService.sendMessageWithKeyboard(senderId, "send your location :)", inlineKeyboard);
        taxiDriverService.getAllDrivers()
                .forEach(taxiDriver -> telegramBotService.sendMessage(taxiDriver.getTelegramId(), message));
    }
}
