package com.api.controller;

import com.api.dto.CocheraDtoListar;
import com.api.dto.CocheraDtoRegistrar;
import com.api.errores.ValidacionIntegridad;
import com.api.service.CocheraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cochera")
@RequiredArgsConstructor
public class CocheraController {

    private final CocheraService service;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody CocheraDtoRegistrar datos)throws ValidacionIntegridad {
        service.registrarCochera(datos);
        return new ResponseEntity<>("Cochera registrada con éxito", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<CocheraDtoListar>> listar(@PageableDefault(size = 5,sort = {"nombre"}) Pageable pageable){
        var response = service.listarCocheras(pageable);
        return ResponseEntity.ok(response);
    }
}
