package com.driverHub.core.service;

import com.driverHub.core.model.RideContractEntity;
import com.driverHub.core.repository.RideContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final RideContractRepository rideContractRepository;

    @Override
    public Optional<RideContractEntity> getById(Long contractId) {
        return rideContractRepository.findById(contractId);
    }

    @Override
    public RideContractEntity saveContract(RideContractEntity rideContractEntity) {
        return rideContractRepository.save(rideContractEntity);
    }

    @Override
    public List<RideContractEntity> findAllNotCompletedContractsForClient(Long clientTelegramId) {
        return rideContractRepository.getByClient_TelegramIdAndCompletedFalse(clientTelegramId);
    }

    @Override
    public void completeRiding(RideContractEntity rideContractEntity) {
        rideContractEntity.setCompleted(true);
        rideContractRepository.save(rideContractEntity);
    }
}
