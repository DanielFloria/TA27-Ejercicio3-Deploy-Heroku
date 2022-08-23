package com.crud.service;

import java.util.List;

import com.crud.dto.Cajero;

public interface ICajeroService {
	public Cajero guardarCajero(Cajero cajero);
	
	public List<Cajero> listarCajero();
	
	public Cajero cajeroPorId(Long id);	
	
	public Cajero actualizarCajero(Cajero cajero);	
	
	public void eliminarCajero(Long id);
}
