package com.alberto.proyectofinal.entity;


import java.util.Date;

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
	private Date fechanac;
	
	private String raza;
	
	private int peso;
	
	private boolean tiene_chip;
	
	private String url_foto;
	
	

	public Mascota(Long id, String nombre, Date fechanac, String raza, int peso, boolean tiene_chip,
			String url_foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechanac = fechanac;
		this.raza = raza;
		this.peso = peso;
		this.tiene_chip = tiene_chip;
		this.url_foto = url_foto;
	}

	public Mascota() {
	}	

}
