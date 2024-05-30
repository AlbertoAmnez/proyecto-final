package com.alberto.proyectofinal.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="mascota")

public class Mascota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fecha_nac;
	
	private String raza;
	
	private int peso;
	
	private boolean tiene_chip;
	
	private String url_foto;
	
	

	public Mascota(Long id, String nombre, String fecha_nac, String raza, int peso, boolean tiene_chip,
			String url_foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
		this.raza = raza;
		this.peso = peso;
		this.tiene_chip = tiene_chip;
		this.url_foto = url_foto;
	}

	public Mascota() {
	}	

}
