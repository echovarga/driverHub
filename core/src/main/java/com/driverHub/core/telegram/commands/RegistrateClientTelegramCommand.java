package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;

import java.util.Map;

public class RegistrateClientTelegramCommand extends TelegramCommand{
    //TODO replace with annotation
    public RegistrateClientTelegramCommand() {
        commandText = "/starts";
        commandDescription ="Starts Bot Command";
    }

    //TODO
    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Map<String, String> data) {

    }
}
