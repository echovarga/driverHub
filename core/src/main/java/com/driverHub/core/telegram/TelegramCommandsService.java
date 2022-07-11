package com.driverHub.core.telegram;

import com.driverHub.core.telegram.commands.TelegramCommand;

import java.util.Optional;

public interface TelegramCommandsService {
    TelegramCommand getCommandByCommandText(String commandText);

    Optional<TelegramCommand> getCommandFromUpdateIfExist(String commandText);
}
