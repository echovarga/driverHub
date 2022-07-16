package com.driverHub.core.service;

import com.driverHub.core.model.ClientEntity;
import com.driverHub.core.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public ClientEntity createAndSaveClient(Long telegramId, String name, String phone) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setTelegramId(telegramId);
        clientEntity.setName(name);
        clientEntity.setPhone(phone);
        return clientRepository.save(clientEntity);
    }

    @Override
    public Optional<ClientEntity> getClientByTelegramId(Long telegramId) {
        return clientRepository.getByTelegramId(telegramId);
    }
}
