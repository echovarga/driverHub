package com.driverHub.core.telegram.commands;

import com.driverHub.core.model.RideContractEntity;
import com.driverHub.core.service.ContractService;
import com.driverHub.core.service.TaxiDriverService;
import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.BotCommandsTexts;
import com.pengrad.telegrambot.model.Update;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class EndDriveTelegramCommand implements TelegramCommand {
    private final String commandText = BotCommandsTexts.END_RIDING.getCommandText();
    private final String commandDescription = BotCommandsTexts.END_RIDING.getCommandDescription();
    private final TelegramBotService telegramBotService;
    private final TaxiDriverService taxiDriverService;
    private final ContractService contractService;

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final Long contractId = Long.valueOf(update.callbackQuery().data());
        RideContractEntity contractEntity = contractService.getById(contractId)
                .orElseThrow();//TODO
        contractService.completeRiding(contractEntity);
        telegramBotService.sendMessage(contractEntity.getClient().getTelegramId(), "Riding was completed");
        telegramBotService.sendMessage(contractEntity.getTaxiDriver().getTelegramId(), "Riding was completed");
    }
}
