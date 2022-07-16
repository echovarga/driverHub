package com.driverHub.core.service;

import com.driverHub.core.model.ClientEntity;
import com.driverHub.core.model.Geolocation;
import com.driverHub.core.model.TaxiDriverEntity;

public interface ContractService {
    void createContract(ClientEntity client, TaxiDriverEntity taxiDriver, Geolocation clientGeoLocation);
}
