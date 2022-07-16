package com.driverHub.core.telegram;

import lombok.Getter;

@Getter
public enum BotCommandsTexts {
    STARTS("/starts", "Starts Bot Command"),
    REGISTRATE_CLIENT("/registrate_client", "Registrate Client Command"),
    REGISTRATE_DRIVER("/registrate_driver", "Registrate Driver Command"),
    WANT_TAXI("/want_taxi", "Want Taxi Command"),
    GET_TAXI("Press the button", "Get Taxi Command"),
    ACCEPT_RIDING("/accept_riding", "Accept riding"),
    END_RIDING("/end_riding", "End riding");

    private final String commandText;
    private final String commandDescription;

    BotCommandsTexts(String commandText, String commandDescription) {
        this.commandText = commandText;
        this.commandDescription = commandDescription;
    }
}
