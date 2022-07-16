package com.driverHub.core.service;

import com.driverHub.core.model.RideContractEntity;

import java.util.List;

public interface ContractService {
    RideContractEntity saveContract(RideContractEntity rideContractEntity);

    List<RideContractEntity> findAllNotCompletedContractsForClient(Long clientTelegramId);
}
