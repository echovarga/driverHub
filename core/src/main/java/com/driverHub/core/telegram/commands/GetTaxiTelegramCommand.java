package com.driverHub.core.telegram.commands;

import com.driverHub.core.model.ClientEntity;
import com.driverHub.core.model.RideContractEntity;
import com.driverHub.core.service.ClientService;
import com.driverHub.core.service.ContractService;
import com.driverHub.core.service.TaxiDriverService;
import com.driverHub.core.service.TelegramBotService;
import com.driverHub.core.telegram.BotCommandsTexts;
import com.pengrad.telegrambot.model.Location;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class GetTaxiTelegramCommand implements TelegramCommand {
    private final String commandText = BotCommandsTexts.GET_TAXI.getCommandText();
    private final String commandDescription = BotCommandsTexts.GET_TAXI.getCommandDescription();
    private final String completeSendingClientMessage = "Dear Client, your GetTaxi request has been sent to drivers";
    private final TelegramBotService telegramBotService;
    private final TaxiDriverService taxiDriverService;
    private final ContractService contractService;
    private final ClientService clientService;

    @Override
    public void applyCommandAction(TelegramBotService telegramBotService, Update update) {
        final Long clientTelegramId = update.message().from().id();
        if (contractService.findAllNotCompletedContractsForClient(clientTelegramId).size() > 0) {
            telegramBotService.sendMessage(clientTelegramId, "You already have an active ride contract");
            return;
        }
        Optional<ClientEntity> optionalClientEntity = clientService.getClientByTelegramId(clientTelegramId);
        if (optionalClientEntity.isEmpty()) {
            telegramBotService.sendMessage(clientTelegramId, "You need to registrate first");
            return;
        }
        createAndSaveRideContractForClient(update.message().location(), optionalClientEntity.get());
        sendTaxiRequestToAllFreeDriversAndNotifyClient(update.message().location(), update.message().from());
    }

    private void createAndSaveRideContractForClient(Location location, ClientEntity clientEntity) {
        RideContractEntity rideContractEntity = new RideContractEntity();
        rideContractEntity.setClient(clientEntity);
        rideContractEntity.setClientLatitude(location.latitude());
        rideContractEntity.setClientLongitude(location.longitude());
        contractService.saveContract(rideContractEntity);
    }

    private void sendTaxiRequestToAllFreeDriversAndNotifyClient(Location location, User client) {
        final String message = String.format("Hi, %s wants to ride!. It's his location", client.firstName());
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton(BotCommandsTexts.ACCEPT_RIDING.getCommandText()).callbackData(client.id().toString()),
                new InlineKeyboardButton("Deny riding").switchInlineQuery(client.id().toString()));
        taxiDriverService.getAllDrivers()
                .forEach(taxiDriver -> {
                    telegramBotService.sendMessage(taxiDriver.getTelegramId(), message);
                    telegramBotService.sendLocation(taxiDriver.getTelegramId(), location.latitude(), location.longitude());
                    telegramBotService.sendMessageWithKeyboard(taxiDriver.getTelegramId(), "Choose", keyboard);
                });
        telegramBotService.sendMessage(client.id(), completeSendingClientMessage);
    }
}
