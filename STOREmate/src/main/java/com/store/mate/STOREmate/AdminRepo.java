package com.store.mate.STOREmate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, String>{
    Optional<UsersEntity> findByEmailAndPassword(String email, String password);
    public AdminEntity findByEmail(String email);
}
 