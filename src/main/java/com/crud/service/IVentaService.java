package com.crud.service;

import java.util.List;

import com.crud.dto.Venta;

public interface IVentaService {
	public Venta guardarVenta(Venta venta);
	
	public List<Venta> listarVenta();
	
	public Venta ventaPorId(Long id);	
	
	public Venta actualizarVenta(Venta venta);	
	
	public void eliminarVenta(Long id);
}
