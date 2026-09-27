package com.store.mate.STOREmate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    List<CartEntity> findByUserEmail(String userEmail);

    void deleteByUserEmail(String userEmail);

}
