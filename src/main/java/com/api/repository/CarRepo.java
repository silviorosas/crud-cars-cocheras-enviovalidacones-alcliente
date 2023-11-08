package com.api.repository;

import com.api.dto.CarDtoListar;
import com.api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepo extends JpaRepository<Car,Long> {
   Optional<CarDtoListar> findByNombre(String nombre);
   boolean existsByNombre(String nombre);
}
