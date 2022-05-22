package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}