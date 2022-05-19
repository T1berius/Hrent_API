package com.example.repository;

import com.example.model.TypeLogement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeLogementRepository extends JpaRepository<TypeLogement, Integer> {
    List<TypeLogement> findByLibelle(String libelle);
}
