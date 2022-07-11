package com.driverHub.core.service;

import com.driverHub.core.model.ClientEntity;

public interface ClientService {
    ClientEntity createAndSaveClient(Long telegramId, String name, String phone);
}
