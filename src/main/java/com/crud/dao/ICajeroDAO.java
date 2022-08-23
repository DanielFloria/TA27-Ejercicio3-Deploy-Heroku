package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Cajero;

public interface ICajeroDAO extends JpaRepository<Cajero, Long> {

}
