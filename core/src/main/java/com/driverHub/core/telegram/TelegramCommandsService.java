package com.driverHub.core.telegram;

import com.driverHub.core.telegram.commands.TelegramCommand;
import com.pengrad.telegrambot.model.Update;

import java.util.Optional;

public interface TelegramCommandsService {
    TelegramCommand getCommandByCommandText(String commandText);

    Optional<TelegramCommand> getCommandFromUpdateIfExist(Update update);
}
