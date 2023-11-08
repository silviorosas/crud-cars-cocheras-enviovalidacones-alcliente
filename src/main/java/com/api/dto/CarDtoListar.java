package com.api.dto;

import com.api.model.Car;
import com.api.model.Cochera;



public record CarDtoListar(String nombre) {
    public CarDtoListar(Car car){
        this( car.getNombre());
    }
}
