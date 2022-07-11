package com.driverHub.core.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
//TODO upgrade as subclass of TGUser
public class ClientEntity {
    @Id
    private Long id;

    private String telegramId;
    private String name;
    private String phone;

}
