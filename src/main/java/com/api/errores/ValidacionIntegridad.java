package com.api.errores;

public class ValidacionIntegridad extends RuntimeException {
    public ValidacionIntegridad(String s){
        super(s);
    }
}
