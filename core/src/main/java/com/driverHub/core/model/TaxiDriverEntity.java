package com.driverHub.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TaxiDriverEntity {
    @Id
    private Long id;

    private String name;
    private String phone;

    private String car;

    //private Boolean busy;

    private Boolean confirmed;
}
