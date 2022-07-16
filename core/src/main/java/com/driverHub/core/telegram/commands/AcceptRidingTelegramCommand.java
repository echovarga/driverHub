package com.driverHub.core.telegram.commands;

import com.driverHub.core.model.RideContractEntity;
import com.driverHub.core.model.TaxiDriverEntity;
import com.driverHub.core.service.ContractService;
import com.driverHub.core.service.TaxiDriverService;
import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.BotCommandsTexts;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class AcceptRidingTelegramCommand implements TelegramCommand {
    private final String commandText = BotCommandsTexts.ACCEPT_RIDING.getCommandText();
    private final String commandDescription = BotCommandsTexts.ACCEPT_RIDING.getCommandDescription();
    private final TelegramBotService telegramBotService;
    private final TaxiDriverService taxiDriverService;
    private final ContractService contractService;

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final Long clientTelegramId = Long.valueOf(update.callbackQuery().data());
        RideContractEntity rideContractEntity = contractService.findAllNotCompletedContractsForClient(clientTelegramId)
                .stream().reduce((a, b) -> {
                    throw new IllegalStateException("Multiple contracts");
                }).orElseThrow(() -> new IllegalStateException("No contracts"));
        final Long taxiDriverTelegramId = update.callbackQuery().from().id();
        TaxiDriverEntity driverEntity = taxiDriverService.getDriverByTelegramId(taxiDriverTelegramId)
                .orElseThrow(() -> new IllegalStateException("No drivers with such id =" + taxiDriverTelegramId));
        rideContractEntity.setTaxiDriver(driverEntity);
        contractService.saveContract(rideContractEntity);
        telegramBotService.sendMessage(taxiDriverTelegramId, "You successfully accepted ride");
        telegramBotService.sendMessage(clientTelegramId, "Ride was accepted by driver");

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton(BotCommandsTexts.END_RIDING.getCommandText())
                        .callbackData(rideContractEntity.getId().toString()));
        telegramBotService.sendMessageWithKeyboard(taxiDriverTelegramId, "You can end driving", keyboard);
    }
}
