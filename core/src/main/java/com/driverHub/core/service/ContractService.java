package com.driverHub.core.service;

import com.driverHub.core.model.RideContractEntity;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Optional<RideContractEntity> getById(Long contractId);

    RideContractEntity saveContract(RideContractEntity rideContractEntity);

    List<RideContractEntity> findAllNotCompletedContractsForClient(Long clientTelegramId);

    void completeRiding(RideContractEntity rideContractEntity);
}
