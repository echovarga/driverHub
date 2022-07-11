package com.driverHub.core.service;

import com.driverHub.core.model.TaxiDriverEntity;

public interface TaxiDriverService {
    TaxiDriverEntity createAndSaveTaxiDriver(String name, String phone, String car);
}
