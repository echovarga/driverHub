package com.driverHub.core.telegram;

import com.driverHub.core.telegram.commands.TelegramCommand;

public interface TelegramCommandsService {
    TelegramCommand getCommandByCommandText(String commandText);
}
