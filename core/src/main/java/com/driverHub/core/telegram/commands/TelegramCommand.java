package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;
import lombok.Getter;

import java.util.Map;

@Getter
public abstract class TelegramCommand {
    protected String commandText; //starts with "/"
    protected String commandDescription;

    public abstract void applyCommandAction(TelegramBotService telegramBotService, Map<String, String> data);
}
