package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cochera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "cochera", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Car> cars = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
        for(Car car : cars) {
            car.setCochera(this);
        }
    }


/*

  Para crear cochera envio el json:
  {"nombre":"Cochera"}
{
  "nombre":"Uno",
  "precio":1000,
  "categoria":"auto",
  "cochera":{
  "id":3  asigno el id del car
 }
}

* */


}
