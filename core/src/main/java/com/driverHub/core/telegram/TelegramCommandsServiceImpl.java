package com.driverHub.core.telegram;

import com.driverHub.core.telegram.commands.TelegramCommand;

import javax.annotation.Resource;
import java.util.Map;

public class TelegramCommandsServiceImpl implements TelegramCommandsService {
    @Resource(name = "telegramCommandMap")
    Map<String, TelegramCommand> commandMap;

    @Override
    public TelegramCommand getCommandByCommandText(String commandText) {
        return commandMap.get(commandText);
    }
}
