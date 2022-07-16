package com.driverHub.core.telegram;

import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.commands.TelegramCommand;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramUpdatesHandler {
    private final TelegramBot telegramBot;
    private final TelegramBotService telegramBotService;
    private final TelegramCommandsService telegramCommandsService;

    @PostConstruct
    private void init() {
        subscribeOnAllTelegramBotUpdates();
    }

    private void subscribeOnAllTelegramBotUpdates() {
        telegramBot.setUpdatesListener(createUpdatesListener());
    }

    private UpdatesListener createUpdatesListener() {
        return updates -> {
            log.info("updates here");
            updates.forEach(this::handleUpdate);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        };
    }

    private void handleUpdate(Update update) {
        Optional<TelegramCommand> commandFromUpdateIfExist
                = telegramCommandsService.getCommandFromUpdateIfExist(update.message().text());
        if(commandFromUpdateIfExist.isEmpty() && update.message().replyToMessage() != null){
            commandFromUpdateIfExist
                    = telegramCommandsService.getCommandFromUpdateIfExist(update.message().replyToMessage().text());
        }

        commandFromUpdateIfExist.ifPresentOrElse(
                telegramCommand -> telegramCommand.applyCommandAction(telegramBotService, update),
                () -> log.info("command is not found")
        );
    }

}
