package com.api.controller;

import com.api.dto.CarDtoListar;
import com.api.dto.CarDtoRegistrar;
import com.api.errores.ValidacionIntegridad;
import com.api.model.Car;
import com.api.repository.CarRepo;
import com.api.service.CarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private  final CarService service;


	public CarController(CarService service) {
		this.service = service;

	}

	@GetMapping("/mje")
	public String mensaje() {
		return "Hola desde controller";
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> registrar(@RequestBody CarDtoRegistrar datos)throws ValidacionIntegridad{
		service.registrarCar(datos);
		return new ResponseEntity("Car creado con éxito", HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Page<CarDtoListar>> listar(@PageableDefault(size = 5,sort = {"precio"})Pageable pageable){
		var response = service.listarCars(pageable);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity listarPorNombre(@PathVariable String nombre){
		var response = service.buscarPorNombre(nombre);
		return  ResponseEntity.ok(response);
	}



}
