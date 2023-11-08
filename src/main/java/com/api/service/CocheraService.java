package com.api.service;

import com.api.dto.CocheraDtoListar;
import com.api.dto.CocheraDtoRegistrar;
import com.api.errores.ValidacionIntegridad;
import com.api.model.Cochera;
import com.api.repository.CocheraRepo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CocheraService {

    private final CocheraRepo repo;

    public void registrarCochera(CocheraDtoRegistrar datos){

        if (StringUtils.isBlank(datos.nombre()))
            throw new ValidacionIntegridad("Nombre es obligatorio");
        if (repo.existsByNombre(datos.nombre()))
            throw new ValidacionIntegridad("Ya existe el nombre de cochera: "+datos.nombre());
        Cochera cochera = new Cochera();
        cochera.setNombre(datos.nombre());
        repo.save(cochera);

    }

    public Page<CocheraDtoListar> listarCocheras(Pageable paginacion){
        return repo.findAll(paginacion).map(CocheraDtoListar::new);
    }
}
