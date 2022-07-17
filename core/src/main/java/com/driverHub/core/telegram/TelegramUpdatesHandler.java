package com.driverHub.core.telegram;

import com.driverHub.core.service.TelegramBotService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

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
            updates.stream().parallel()
                    .forEach((this::handleUpdate));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        };
    }

    private void handleUpdate(Update update) {
        try {
            telegramCommandsService.getCommandFromUpdateIfExist(update).ifPresentOrElse(
                    telegramCommand -> telegramCommand.applyCommandAction(telegramBotService, update),
                    () -> log.warn("command is not found"));
        }catch (RuntimeException e){
            log.error("Something bad happened during telegram update handling: " + e.getMessage());
            log.info(update.toString());
        }
    }
}
