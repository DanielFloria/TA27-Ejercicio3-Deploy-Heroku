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

import com.crud.dto.Maquina;
import com.crud.service.MaquinaServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaController {

	@Autowired
	MaquinaServiceImpl maquinaServiceImpl;

	@PostMapping("/maquinas")
	public Maquina guardarMaquina(@RequestBody Maquina maquina) {
		return maquinaServiceImpl.guardarMaquina(maquina);
	}

	@GetMapping("/maquinas")
	public List<Maquina> listarMaquina() {
		return maquinaServiceImpl.listarMaquina();
	}

	@GetMapping("/maquinas/{id}")
	public Maquina maquinaPorId(@PathVariable(name="id") Long id) {
		Maquina maquinaPorId = new Maquina();
		maquinaPorId = maquinaServiceImpl.maquinaPorId(id);
		
		return maquinaPorId;
	}	

	@PutMapping("/maquinas/{id}")
	public Maquina actualizarMaquina(@PathVariable(name="id") Long id, @RequestBody Maquina maquina) {
		Maquina maquinaSeleccionado = new Maquina();
		Maquina maquinaActualizado = new Maquina();

		maquinaSeleccionado = maquinaServiceImpl.maquinaPorId(id);

		maquinaSeleccionado.setPiso(maquina.getPiso());

		maquinaActualizado = maquinaServiceImpl.actualizarMaquina(maquinaSeleccionado);

		return maquinaActualizado;
	}

	@DeleteMapping("/maquinas/{id}")
	public void borrarMaquina(@PathVariable(name="id") Long id) {
		maquinaServiceImpl.eliminarMaquina(id);
	}

}
