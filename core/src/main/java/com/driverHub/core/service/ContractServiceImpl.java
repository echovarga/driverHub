package com.driverHub.core.service;

import com.driverHub.core.model.RideContractEntity;
import com.driverHub.core.repository.RideContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final RideContractRepository rideContractRepository;

    @Override
    public RideContractEntity saveContract(RideContractEntity rideContractEntity) {
        return rideContractRepository.save(rideContractEntity);
    }

    @Override
    public List<RideContractEntity> findAllNotCompletedContractsForClient(Long clientTelegramId) {
        return rideContractRepository.getByClient_TelegramId(clientTelegramId);
    }
}
