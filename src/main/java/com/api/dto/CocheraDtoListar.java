package com.api.dto;

import com.api.model.Car;
import com.api.model.Cochera;
import java.util.Set;

public record CocheraDtoListar(String nombre, Set<Car> cars  ) {
    public CocheraDtoListar(Cochera cochera){
        this(cochera.getNombre(),cochera.getCars());
    }


}
