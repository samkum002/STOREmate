package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FrozenFoodsRepo extends JpaRepository<FrozenFoodsEntity, Long> {
    Optional<FrozenFoodsEntity> findByProduct(String product);
}
