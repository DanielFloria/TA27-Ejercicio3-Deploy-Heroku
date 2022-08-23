package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Venta;

public interface IVentaDAO  extends JpaRepository<Venta, Long> {

}
