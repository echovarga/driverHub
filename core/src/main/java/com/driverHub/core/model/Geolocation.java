package com.driverHub.core.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Geolocation {
    @Id
    private Long id;

    private String latitude;
    private String longitude;
}
