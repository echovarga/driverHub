package com.driverHub.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
//TODO upgrade as subclass of TGUser
public class ClientEntity {
    @Id
    private Long id;

    private String telegramId;
    private String name;
    private String phone;

}
