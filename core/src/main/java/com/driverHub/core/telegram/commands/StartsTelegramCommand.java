package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;

import java.util.Map;

public class StartsTelegramCommand extends TelegramCommand{
    //TODO replace with annotation
    public StartsTelegramCommand() {
        commandText = "/starts";
        commandDescription ="Starts Bot Command";
    }

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Map<String, String> data) {
        final String receiverId = data.get("receiverId");
        final String messageText = data.get("messageText");
        telegramBotService.sendMessage(receiverId, messageText);
    }
}
