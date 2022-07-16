package com.driverHub.core.repository;

import com.driverHub.core.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    Optional<ClientEntity> getByTelegramId(Long telegramId);
}
