package com.driverHub.core.service;

import com.driverHub.core.model.ClientEntity;

import java.util.Optional;

public interface ClientService {
    ClientEntity createAndSaveClient(Long telegramId, String name, String phone);

    Optional<ClientEntity> getClientByTelegramId(Long telegramId);
}
