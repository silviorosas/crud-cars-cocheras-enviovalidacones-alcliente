package com.api.dto;

import com.api.model.Categoria;
import com.api.model.Cochera;

public record CarDtoRegistrar(String nombre, Float precio, Categoria categoria, Cochera cochera) {



}
