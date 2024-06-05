package com.alberto.proyectofinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alberto.proyectofinal.data.MascotaRepository;
import com.alberto.proyectofinal.entity.Mascota;
import com.alberto.proyectofinal.service.MascotaService;

@RestController
@RequestMapping(path="/api", produces="application/json")
@CrossOrigin(origins="*")

public class MascotaController {
	
	@Autowired
	private MascotaService service;
	
	@GetMapping("/mascota/id/{id}")
	public ResponseEntity<Mascota> mascotaById(@PathVariable("id") Long id) {
		Optional<Mascota> optMascota = service.buscarPorId(id);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/mascota/nombre/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Mascota>  mascotaByNombre(@PathVariable("nombre") String nombre) {
		Optional<Mascota> optMascota = service.buscarPorNombre(nombre);
		if(optMascota.isPresent()) {
			return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/mascota")
	public Iterable<Mascota> listadoDeMascotas() {
		return service.listadoDeMascotas();
	}
	
	@PostMapping(path="/mascota", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota subirMascota(@RequestBody Mascota mascota) {
		return service.guardar(mascota);
	}
	
	
	@GetMapping("/mascota/jovenes/20")
	public List<Mascota> mascotasMasJovenes() {
	    PageRequest page = PageRequest.of(0, 20, Sort.by("fechanac").ascending());
	    return service.listadoDeMascotas(page).getContent();
	}
	
	@GetMapping("/mascota/page/{page}/size/{size}")
	public Page<Mascota> pagsMascotas(@PathVariable("page") int page, @PathVariable("size") int size) {
	    PageRequest pageRequest = PageRequest.of(page, size);
	    return service.listadoDeMascotas(pageRequest);
	}
	
	@DeleteMapping("/mascota/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarMascota(@PathVariable("id") Long id) {
		service.borrar(id);
	}
	
}
