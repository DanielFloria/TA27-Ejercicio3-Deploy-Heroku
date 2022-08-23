package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Maquina;

public interface IMaquinaDAO  extends JpaRepository<Maquina, Long> {

}
