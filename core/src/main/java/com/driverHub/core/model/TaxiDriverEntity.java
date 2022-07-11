package com.driverHub.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
//TODO upgrade as subclass of TGUser
public class TaxiDriverEntity {
    @Id
    private Long id;

    private String telegramId;
    private String name;
    private String phone;

    private String car;

    //private Boolean busy;

    private Boolean confirmed;
}
