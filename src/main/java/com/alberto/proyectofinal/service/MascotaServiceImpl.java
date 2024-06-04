package com.alberto.proyectofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Optional<Mascota> buscarPorId(Long id) {	
		return repository.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Mascota> buscarPorNombre(String nombre) {	
		return repository.findByNombre(nombre);
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
	
	@Override
    @Transactional(readOnly = true)
    public Page<Mascota> listadoDeMascotas(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
