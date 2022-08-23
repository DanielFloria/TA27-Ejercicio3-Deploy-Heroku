package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.IMaquinaDAO;
import com.crud.dto.Maquina;

@Service
public class MaquinaServiceImpl implements IMaquinaService {

	@Autowired
	IMaquinaDAO iMaquinaDAO;
	
	@Override
	public Maquina guardarMaquina(Maquina maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public List<Maquina> listarMaquina() {
		return iMaquinaDAO.findAll();
	}

	@Override
	public Maquina maquinaPorId(Long id) {
		return iMaquinaDAO.findById(id).get();
	}

	@Override
	public Maquina actualizarMaquina(Maquina maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public void eliminarMaquina(Long id) {
		iMaquinaDAO.deleteById(id);
	}

}
