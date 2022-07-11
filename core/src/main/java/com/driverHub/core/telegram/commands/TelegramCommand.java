package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;

import java.util.Map;

public abstract class TelegramCommand {
    //starts with "/"
    protected String commandText;
    protected String commandDescription;

    public abstract void applyCommandAction(TelegramBotService telegramBotService, Map<String, String> data);
}
