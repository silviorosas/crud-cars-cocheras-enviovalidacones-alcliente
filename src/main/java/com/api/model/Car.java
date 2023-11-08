package com.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "cars",uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Float precio;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	/*@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "cochera_id") para relacion unidireccional*/
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cochera_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Cochera cochera;

}
