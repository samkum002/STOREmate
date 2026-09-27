package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetableRepo extends JpaRepository<VegetablesEntity, Long>{
    Optional<VegetablesEntity> findByProduct(String product);
}
