package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TaxiDriverService;
import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.BotCommandsTexts;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Location;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class GetTaxiTelegramCommand implements TelegramCommand {
    private final String commandText = BotCommandsTexts.GET_TAXI.getCommandText();
    private final String commandDescription = "Get Taxi Command";
    private final String completeSendingClientMessage = "Dear Client, your GetTaxi request has been sent to drivers";
    private final TaxiDriverService taxiDriverService;
    private final TelegramBotService telegramBotService;
    private final TelegramBot telegramBot;

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final String message = String.format("Hi, %s wants to ride!", update.message().from().firstName());
        final Location geolocation = update.message().location();
        taxiDriverService.getAllDrivers()
                .forEach(taxiDriver -> {
                    telegramBotService.sendMessage(taxiDriver.getTelegramId(), message);
                    telegramBotService.sendLocation(taxiDriver.getTelegramId(), geolocation.latitude(), geolocation.longitude());
                });

        final Long senderId = update.message().from().id();
        telegramBotService.sendMessage(senderId, completeSendingClientMessage);
    }
}
