package com.driverHub.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CallEventEntity {
    @Id
    private Long id;

    @OneToOne
    private ClientEntity client;

    private String clientLatitude;
    private String clientLongitude;
}
