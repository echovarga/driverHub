package com.driverHub.core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class RideContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ClientEntity client;
    @OneToOne
    private TaxiDriverEntity taxiDriver;

    private float clientLatitude;
    private float clientLongitude;

    private Boolean completed = false;
}
