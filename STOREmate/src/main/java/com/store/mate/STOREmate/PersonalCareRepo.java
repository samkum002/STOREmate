package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalCareRepo extends JpaRepository<PersonalCareEntity, Long>{
    Optional<PersonalCareEntity> findByProduct(String product);
}
