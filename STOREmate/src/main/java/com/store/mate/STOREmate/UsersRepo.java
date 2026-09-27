package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<UsersEntity, Long>{
    Optional<UsersEntity> findByEmailAndPassword(String email, String password);
    public UsersEntity findByEmail(String email);
    Optional<UsersEntity> findByPhone(String phone);
}
