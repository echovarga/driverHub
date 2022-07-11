package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;

import java.util.Map;

public class RegistrateDriverTelegramCommand extends TelegramCommand{
    //TODO replace with annotation
    public RegistrateDriverTelegramCommand() {
        commandText = "/starts";
        commandDescription ="Starts Bot Command";
    }

    //TODO
    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Map<String, String> data) {

    }
}
