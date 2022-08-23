package com.crud.service;

import java.util.List;

import com.crud.dto.Maquina;

public interface IMaquinaService {
	public Maquina guardarMaquina(Maquina maquina);
	
	public List<Maquina> listarMaquina();
	
	public Maquina maquinaPorId(Long id);	
	
	public Maquina actualizarMaquina(Maquina maquina);	
	
	public void eliminarMaquina(Long id);
}
