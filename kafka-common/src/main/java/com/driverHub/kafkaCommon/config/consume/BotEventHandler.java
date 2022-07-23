package com.driverHub.kafkaCommon.config.consume;

import com.driverHub.kafkaCommon.config.event.KafkaCommonBotCommandEvent;

import java.util.List;

public interface BotEventHandler {
    void handleEvent(KafkaCommonBotCommandEvent botCommandEvent);

    /**
     * @return Texts of commands that implementation of this handler will handle
     */
    List<String> getHandleableCommands();
}
