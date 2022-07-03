package com.driverHub.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class RideContractEntity {
    @Id
    private Long id;

    @OneToOne
    private ClientEntity client;
    @OneToOne
    private TaxiDriverEntity taxiDriver;

    private String clientLatitude;
    private String clientLongitude;
}
