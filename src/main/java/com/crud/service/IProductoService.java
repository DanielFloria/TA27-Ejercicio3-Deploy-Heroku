package com.crud.service;

import java.util.List;

import com.crud.dto.Producto;

public interface IProductoService {
	public Producto guardarProducto(Producto producto);
	
	public List<Producto> listarProducto();
	
	public Producto productoPorId(Long id);	
	
	public Producto actualizarProducto(Producto producto);	
	
	public void eliminarProducto(Long id);
}
