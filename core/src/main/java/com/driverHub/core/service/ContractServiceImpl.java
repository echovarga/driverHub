package com.driverHub.core.service;

import com.driverHub.core.model.ClientEntity;
import com.driverHub.core.model.GeoLocation;
import com.driverHub.core.model.TaxiDriverEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{
    @Override
    public void createContract(ClientEntity client, TaxiDriverEntity taxiDriver, GeoLocation clientGeoLocation) {

    }
}
