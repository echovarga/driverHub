package com.driverHub.kafkaCommon.config.event;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class KafkaCommonBotCommandEvent {
    /**
     * Correctly it would be good to create different events and topics  for each bot command type
     * to see explicitly what fields should be filled. But it would take too much effort for not enterprise app
     */

    private String commandText;

    private Long messageFromId;
    private String messageFromName;
    private Long messageLocationLongitude;
    private String messageLocationLatitude;

    private String callbackQueryData;
    private String callbackFromId;
}
