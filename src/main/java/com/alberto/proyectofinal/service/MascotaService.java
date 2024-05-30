package com.alberto.proyectofinal.service;

import java.util.List;

import com.alberto.proyectofinal.entity.Mascota;

public interface MascotaService {
	
	public List<Mascota> listadoDeMascotas();
	
	public Mascota buscarPorId(Long id);
	
	public Mascota buscarPorNombre(String nombre);

	public Mascota guardar (Mascota mascota);
	
	public Mascota borrar (Long id);

}
