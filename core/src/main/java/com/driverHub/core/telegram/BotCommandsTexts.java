package com.driverHub.core.telegram;

import lombok.Getter;

@Getter
public enum BotCommandsTexts {
    STARTS("/starts"),
    REGISTRATE_CLIENT("/registrateClient"),
    REGISTRATE_DRIVER("/registrateDriver"),
    WANT_TAXI("/wantTaxi"),
    GET_TAXI("/getTaxi");

    private final String commandText;

    BotCommandsTexts(String commandText) {
        this.commandText = commandText;
    }
}
