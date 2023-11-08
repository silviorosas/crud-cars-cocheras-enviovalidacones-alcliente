package com.api.errores;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class TratadorErrores {
    @ExceptionHandler(ValidacionIntegridad.class)
    public ResponseEntity errorHandlerValidIntegridad(Exception e){
        return  ResponseEntity.badRequest().body(e.getMessage());
    }







}
