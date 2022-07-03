package com.driverHub.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ClientEntity {
    @Id
    private Long id;

    private String name;
    private String phone;

}
