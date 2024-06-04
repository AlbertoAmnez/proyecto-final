package com.alberto.proyectofinal.data;



import java.util.Optional;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.alberto.proyectofinal.entity.Mascota;



public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long> {
	
	Optional<Mascota> findByNombre(String nombre);

}
