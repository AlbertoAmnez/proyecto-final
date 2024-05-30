package com.alberto.proyectofinal.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.alberto.proyectofinal.entity.Mascota;


public interface MascotaRepository extends CrudRepository<Mascota, Long> {
	
	Optional<Mascota> findByNombre(String nombre);

}
