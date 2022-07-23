package com.driverHub.kafkaCommon.consume;

import com.driverHub.kafkaCommon.event.KafkaCommonBotCommandEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class KafkaEventListener {
    private final List<BotEventHandler> eventHandlers;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @KafkaListener(topics = "${kafka.myTopic}")
    void consumeEvent(KafkaCommonBotCommandEvent botEvent) {
        eventHandlers.stream()
                .filter(handler -> handler.getHandleableCommands().contains(botEvent.getCommandText()))
                .forEach(handler -> executorService.submit(() -> handler.handleEvent(botEvent)));
    }
}
