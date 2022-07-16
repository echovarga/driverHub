package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.BotCommandsTexts;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RegistrateDriverTelegramCommand implements TelegramCommand{
    private final String commandText = BotCommandsTexts.REGISTRATE_DRIVER.getCommandText();
    private final String commandDescription = "Registrate Driver Command";

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final Long telegramId = update.message().from().id();
        final String name = update.message().from().firstName();
        final String phone = "phone";
        final String car = "car";
        telegramBotService.registrateDriver(telegramId, name, phone, car);
    }
}
