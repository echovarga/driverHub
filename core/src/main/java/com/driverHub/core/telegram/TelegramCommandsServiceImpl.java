package com.driverHub.core.telegram;

import com.driverHub.core.telegram.commands.TelegramCommand;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
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
    public Optional<TelegramCommand> getCommandFromUpdateIfExist(Update update) {
        final Message message = update.message();
        if (message != null && commandMap.containsKey(message.text())) {
            return Optional.ofNullable(commandMap.get(message.text()));
        }

        if(message != null && update.message().replyToMessage() != null
                && commandMap.containsKey(update.message().replyToMessage().text())){
            return Optional.ofNullable(commandMap.get(update.message().replyToMessage().text()));
        }

        if (update.callbackQuery() == null || update.callbackQuery().message() == null
                || update.callbackQuery().message().replyMarkup() == null ){
            return Optional.empty();
        }
        String buttonText = Arrays.stream(Arrays.stream(update.callbackQuery().message().replyMarkup().inlineKeyboard())
                .findFirst().get()).findFirst().get().text();
        if (commandMap.containsKey(buttonText)) {
            return Optional.ofNullable(commandMap.get(buttonText));
        }

        return Optional.empty();
    }
}
