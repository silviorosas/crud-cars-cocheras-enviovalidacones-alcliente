package com.api.repository;

import com.api.dto.CocheraDtoListar;
import com.api.model.Cochera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CocheraRepo extends JpaRepository<Cochera,Long> {
    Optional<CocheraDtoListar> findByNombre(String nombre);
    boolean existsByNombre(String nombre);


}
