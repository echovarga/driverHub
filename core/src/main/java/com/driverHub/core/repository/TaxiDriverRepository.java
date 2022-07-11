package com.driverHub.core.repository;

import com.driverHub.core.model.TaxiDriverEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiDriverRepository extends CrudRepository<TaxiDriverEntity, Long> {
}
