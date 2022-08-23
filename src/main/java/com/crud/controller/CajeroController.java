package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.Cajero;
import com.crud.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;

	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		return cajeroServiceImpl.guardarCajero(cajero);
	}

	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros() {
		return cajeroServiceImpl.listarCajero();
	}

	@GetMapping("/cajeros/{id}")
	public Cajero cajeroPorId(@PathVariable(name="id") Long id) {
		Cajero cajeroPorId = new Cajero();
		cajeroPorId = cajeroServiceImpl.cajeroPorId(id);
		
		return cajeroPorId;
	}	

	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name="id") Long id, @RequestBody Cajero cajero) {
		Cajero cajeroSeleccionado = new Cajero();
		Cajero cajeroActualizado = new Cajero();

		cajeroSeleccionado = cajeroServiceImpl.cajeroPorId(id);

		cajeroSeleccionado.setNom_apels(cajero.getNom_apels());

		cajeroActualizado = cajeroServiceImpl.actualizarCajero(cajeroSeleccionado);

		return cajeroActualizado;
	}

	@DeleteMapping("/cajeros/{id}")
	public void borrarCajero(@PathVariable(name="id") Long id) {
		cajeroServiceImpl.eliminarCajero(id);
	}

}

