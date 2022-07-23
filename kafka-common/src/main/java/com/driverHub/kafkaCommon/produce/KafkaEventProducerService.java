package com.driverHub.kafkaCommon.produce;

import com.driverHub.kafkaCommon.event.KafkaCommonBotCommandEvent;

public interface KafkaEventProducerService {
    void publishCommonBotEvent(KafkaCommonBotCommandEvent botCommandEvent);
}
