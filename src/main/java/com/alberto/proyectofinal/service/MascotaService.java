package com.alberto.proyectofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alberto.proyectofinal.entity.Mascota;

public interface MascotaService {
	
	public List<Mascota> listadoDeMascotas();
	
	public Optional<Mascota> buscarPorNombre(String nombre);
	
	public Optional<Mascota> buscarPorId(Long id);
	

	public Mascota guardar (Mascota mascota);
	
	public Mascota borrar (Long id);
	
	public Page<Mascota> listadoDeMascotas(Pageable pageable);

}
