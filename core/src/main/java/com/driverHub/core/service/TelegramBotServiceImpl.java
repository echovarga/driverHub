package com.driverHub.core.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotServiceImpl implements TelegramBotService {
    private final TelegramBot telegramBot;

    @PostConstruct
    private void init() {
        subscribeOnAllTelegramBotEvents();
    }

    @Override
    public void createEvent() {
        SendMessage request = new SendMessage("-696985944", "hi")
                .parseMode(ParseMode.HTML);
        // .disableWebPagePreview(true)
        // .disableNotification(true)
        //.replyToMessageId(1)
        // .replyMarkup(new ForceReply());
        Keyboard keyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton("text").callbackData("callback123"),
                new InlineKeyboardButton("contact").callbackData("callback123"),
                new InlineKeyboardButton("location").callbackData("callback123")
        );
        request.replyMarkup(keyboard);
        log.info("here");
        telegramBot.execute(request);
    }

    @Override
    public void sendMessage(String receiverId, String messageText) {
        SendMessage request = new SendMessage(receiverId, messageText)
                .parseMode(ParseMode.HTML);
        telegramBot.execute(request);
    }

    @Override
    public void subscribeOnAllTelegramBotEvents() {
        telegramBot.setUpdatesListener(createUpdatesListener());
    }

    private UpdatesListener createUpdatesListener() {
        return updates -> {
            // process updates
            log.info("updates here");
            updates.forEach(update -> log.info(update.toString()));
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        };
    }
}
