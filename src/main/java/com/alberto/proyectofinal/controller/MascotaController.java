package com.alberto.proyectofinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alberto.proyectofinal.data.MascotaRepository;
import com.alberto.proyectofinal.entity.Mascota;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")

public class MascotaController {
	
	@Autowired
	private MascotaRepository repository;
	
	@GetMapping("/mascota/{id}")
	public ResponseEntity<Mascota> mascotaById(@PathVariable("id") Long id) {
		Optional<Mascota> optMascota = repository.findById(id);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
