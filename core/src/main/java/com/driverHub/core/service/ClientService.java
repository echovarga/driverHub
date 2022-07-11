package com.driverHub.core.service;

import com.driverHub.core.model.ClientEntity;

public interface ClientService {
    ClientEntity createAndSaveClient(String name, String phone);
}
