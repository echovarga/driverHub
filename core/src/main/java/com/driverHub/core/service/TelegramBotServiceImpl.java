package com.driverHub.core.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class TelegramBotServiceImpl implements TelegramBotService {
    private final TelegramBot telegramBot;

    @PostConstruct
    @Override
    public void createEvent(){
        SendMessage request = new SendMessage("696985944", "test message text")
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(true)
                .replyToMessageId(1)
                .replyMarkup(new ForceReply());
        telegramBot.execute(request);
    }
}
