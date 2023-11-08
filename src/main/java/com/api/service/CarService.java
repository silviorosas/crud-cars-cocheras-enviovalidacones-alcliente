package com.api.service;

import com.api.dto.CarDtoListar;
import com.api.dto.CarDtoRegistrar;
import com.api.errores.ValidacionIntegridad;
import com.api.model.Car;
import com.api.repository.CarRepo;
import com.api.repository.CocheraRepo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    public final CarRepo repo;
    public final CocheraRepo cocheraRepo;

    public void registrarCar(CarDtoRegistrar datos){
        if(StringUtils.isBlank(datos.nombre()))
            throw new ValidacionIntegridad("El nombre es obligatorio");//vinvulado a paq err
        if(repo.existsByNombre(datos.nombre()))
            throw new ValidacionIntegridad("El nombre ya existe");
        if(datos.precio() == null || datos.precio()<= 0)
            throw new ValidacionIntegridad("Precio obligatorio y/o mayor a 0");
       // if (datos.piloto() == null )
         //   throw new ValidacionIntegridad("Piloto es obligatorio");
       // if (pilotoRepo.existsByNombre(datos.piloto().getNombre()))
          //  throw new ValidacionIntegridad("Nombre piloto ya existe!");
       // if(StringUtils.isBlank(datos.piloto().getNombre()))
       //     throw new ValidacionIntegridad("Nombre de piloto es obligatorio");
        if (datos.categoria() == null )
            throw new ValidacionIntegridad("Categoria debe ser AUTO o CAMIONETA");
        if (!cocheraRepo.existsById(datos.cochera().getId()))
            throw new ValidacionIntegridad("No existe cochera");


        var car =  new Car();
        car.setNombre(datos.nombre());
        car.setPrecio(datos.precio());
        car.setCategoria(datos.categoria());
        car.setCochera(datos.cochera());


        repo.save(car);
    }

    public Page<CarDtoListar> listarCars(Pageable paginacion){
        return repo.findAll(paginacion).map(CarDtoListar::new);
    }

    public Optional<CarDtoListar> buscarPorNombre(String nombre){
        if(!repo.existsByNombre(nombre))
            throw new ValidacionIntegridad("No existe nombre ingresado");
        return repo.findByNombre(nombre);
    }
}
