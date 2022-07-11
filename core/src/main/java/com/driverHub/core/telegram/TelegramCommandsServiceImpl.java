package com.driverHub.core.telegram;

import com.driverHub.core.telegram.commands.TelegramCommand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class TelegramCommandsServiceImpl implements TelegramCommandsService {
    @Resource(name = "telegramCommandMap")
    Map<String, TelegramCommand> commandMap;

    @Override
    public TelegramCommand getCommandByCommandText(String commandText) {
        return commandMap.get(commandText);
    }

    @Override
    public Optional<TelegramCommand> getCommandFromUpdateIfExist(String commandText) {
        if (commandMap.containsKey(commandText)) {
            return Optional.ofNullable(commandMap.get(commandText));
        }
        return Optional.empty();
    }

}
