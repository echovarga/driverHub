package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StartsTelegramCommand implements TelegramCommand{
    private final String commandText = "/starts";
    private final String commandDescription = "Starts Bot Command";

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final Long senderId = update.message().from().id();
        final String senderName = update.message().from().firstName();
        telegramBotService.sendMessage(senderId, "Hi " + senderName);
    }
}
