package com.alberto.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alberto.proyectofinal.data.MascotaRepository;
import com.alberto.proyectofinal.entity.Mascota;



@Service
public class MascotaServiceImpl implements MascotaService {
	
	@Autowired
	private MascotaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Mascota> listadoDeMascotas() {
		return (List<Mascota>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Mascota buscarPorId(Long id) {	
		return repository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Mascota buscarPorNombre(String nombre) {	
		return repository.findByNombre(nombre).orElse(null);
	}

	@Override
	public Mascota guardar(Mascota mascota) {
		return repository.save(mascota);
	}

	@Override
	@Transactional
	public Mascota borrar(Long id) {
		Mascota mascotaBorrada= repository.findById(id).orElse(null);
		repository.deleteById(id);
		
		return mascotaBorrada;
	}

}
