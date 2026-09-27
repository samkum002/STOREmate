package com.store.mate.STOREmate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeveragesRepo extends JpaRepository<BeveragesEntity,Long>{
    Optional<BeveragesEntity> findByProduct(String product);
}
