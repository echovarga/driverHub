package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;
import com.pengrad.telegrambot.model.Update;

import java.util.Map;


public interface TelegramCommand {

    void applyCommandAction(TelegramBotService telegramBotService, Update update);

    String getCommandText();

    String getCommandDescription();
}
