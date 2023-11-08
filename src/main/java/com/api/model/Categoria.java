package com.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;


public enum Categoria {


    AUTO,
    CAMIONETA;


   @JsonCreator
    public static Categoria fromString(String value) {
        for (Categoria cat : Categoria.values()) {
            if (cat.name().equalsIgnoreCase(value)) {
                return cat;
            }
        }
       return null;//el null es validado en carservice y retorna el mje de error correspondiente
    }


}
