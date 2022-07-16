package com.driverHub.core.service;

import com.driverHub.core.model.TaxiDriverEntity;

import java.util.Optional;

public interface TaxiDriverService {
    TaxiDriverEntity createAndSaveTaxiDriver(Long telegramId, String name, String phone, String car);

    Optional<TaxiDriverEntity> getDriverByTelegramId(Long telegramId);

    Iterable<TaxiDriverEntity> getAllDrivers();
}
