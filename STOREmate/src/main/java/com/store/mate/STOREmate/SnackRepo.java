package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackRepo extends JpaRepository<SnacksEntity, Long>{
    Optional<SnacksEntity> findByProduct(String product);
}
