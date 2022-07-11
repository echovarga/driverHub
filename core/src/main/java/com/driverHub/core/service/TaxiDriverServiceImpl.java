package com.driverHub.core.service;

import com.driverHub.core.model.TaxiDriverEntity;
import com.driverHub.core.repository.TaxiDriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxiDriverServiceImpl implements TaxiDriverService {
    private final TaxiDriverRepository taxiDriverRepository;

    @Override
    public TaxiDriverEntity createAndSaveTaxiDriver(Long telegramId, String name, String phone, String car) {
        TaxiDriverEntity taxiDriverEntity = new TaxiDriverEntity();
        taxiDriverEntity.setTelegramId(telegramId);
        taxiDriverEntity.setName(name);
        taxiDriverEntity.setPhone(phone);
        taxiDriverEntity.setCar(car);
        return taxiDriverRepository.save(taxiDriverEntity);
    }

    @Override
    public Iterable<TaxiDriverEntity> getAllDrivers() {
        return taxiDriverRepository.findAll();
    }
}
