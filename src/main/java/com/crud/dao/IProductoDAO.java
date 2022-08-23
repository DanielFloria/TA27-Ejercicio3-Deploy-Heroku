package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Producto;

public interface IProductoDAO  extends JpaRepository<Producto, Long> {

}
