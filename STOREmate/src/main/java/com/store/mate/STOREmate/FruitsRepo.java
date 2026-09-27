package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitsRepo extends JpaRepository<FruitsEntity, Long>{
    Optional<FruitsEntity> findByProduct(String product);
}
