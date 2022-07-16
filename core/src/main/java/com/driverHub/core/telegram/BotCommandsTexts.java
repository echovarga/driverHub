package com.driverHub.core.telegram;

import lombok.Getter;

@Getter
public enum BotCommandsTexts {
    STARTS("/starts", "Starts Bot Command"),
    REGISTRATE_CLIENT("/registrateClient", "Registrate Client Command"),
    REGISTRATE_DRIVER("/registrateDriver", "Registrate Driver Command"),
    WANT_TAXI("/wantTaxi", "Want Taxi Command"),
    GET_TAXI("Press the button", "Get Taxi Command");

    private final String commandText;
    private final String commandDescription;

    BotCommandsTexts(String commandText, String commandDescription) {
        this.commandText = commandText;
        this.commandDescription = commandDescription;
    }
}
