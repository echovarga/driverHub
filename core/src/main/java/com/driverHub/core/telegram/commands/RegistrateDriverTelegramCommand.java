package com.driverHub.core.telegram.commands;

import com.driverHub.core.service.TelegramBotService;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RegistrateDriverTelegramCommand implements TelegramCommand{
    private final String commandText = "/registrateDriver";
    private final String commandDescription = "Registrate Driver Command";

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final String name = update.message().from().firstName();
        final String phone = "phone";
        final String car = "car";
        telegramBotService.registrateDriver(name, phone, car);
    }
}
