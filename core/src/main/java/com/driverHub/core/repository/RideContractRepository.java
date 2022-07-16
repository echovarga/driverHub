package com.driverHub.core.repository;

import com.driverHub.core.model.RideContractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideContractRepository extends CrudRepository<RideContractEntity, Long> {
    List<RideContractEntity> getByClient_TelegramIdAndCompletedFalse(Long clientTelegramId);
}
