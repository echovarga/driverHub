package com.driverHub.kafkaCommon.config.produce;

import com.driverHub.kafkaCommon.config.event.KafkaCommonBotCommandEvent;

public interface KafkaEventProducerService {
    void publishCommonBotEvent(KafkaCommonBotCommandEvent botCommandEvent);
}
