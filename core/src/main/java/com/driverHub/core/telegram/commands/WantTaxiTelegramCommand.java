package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.BotCommandsTexts;
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
public class WantTaxiTelegramCommand implements TelegramCommand {
    private final String commandText = BotCommandsTexts.WANT_TAXI.getCommandText();
    private final String commandDescription = BotCommandsTexts.WANT_TAXI.getCommandDescription();
    private final String getTaxiText = "Please, press \"Get Taxi\" button to get a taxi. It will request yor location";

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final Long senderId = update.message().from().id();
        telegramBotService.sendMessage(senderId, getTaxiText);

        Keyboard keyboard = new ReplyKeyboardMarkup(new KeyboardButton("Get Taxi").requestLocation(true))
                .resizeKeyboard(true);
        telegramBotService.sendMessageWithKeyboard(senderId, BotCommandsTexts.GET_TAXI.getCommandText(), keyboard);
    }
}
