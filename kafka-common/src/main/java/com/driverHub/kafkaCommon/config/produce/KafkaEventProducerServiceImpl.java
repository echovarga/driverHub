package com.driverHub.kafkaCommon.config.produce;

import com.driverHub.kafkaCommon.config.event.KafkaCommonBotCommandEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaEventProducerServiceImpl implements KafkaEventProducerService {
    private final KafkaTemplate<String, KafkaCommonBotCommandEvent> kafkaTemplate;
    @Value("${kafka.myTopic}")
    private String topicName;

    @Override
    public void publishCommonBotEvent(KafkaCommonBotCommandEvent botCommandEvent) {
        kafkaTemplate.send(topicName, botCommandEvent);
    }
}
