package com.driverHub.core.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeoLocation {
    @Id
    private Long id;

    private String latitude;
    private String longitude;
}
