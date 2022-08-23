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

import com.crud.dto.Venta;
import com.crud.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServiceImpl ventaServiceImpl;

	@PostMapping("/ventas")
	public Venta guardarVenta(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}

	@GetMapping("/ventas")
	public List<Venta> listarVentas() {
		return ventaServiceImpl.listarVenta();
	}

	@GetMapping("/ventas/{id}")
	public Venta ventaPorId(@PathVariable(name="id") Long id) {
		Venta ventaPorId = new Venta();
		ventaPorId = ventaServiceImpl.ventaPorId(id);
		
		return ventaPorId;
	}	

	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id") Long id, @RequestBody Venta venta) {
		Venta ventaSeleccionado = new Venta();
		Venta ventaActualizado = new Venta();

		ventaSeleccionado = ventaServiceImpl.ventaPorId(id);

		ventaSeleccionado.setCajero(venta.getCajero());
		ventaSeleccionado.setProducto(venta.getProducto());
		ventaSeleccionado.setMaquina(venta.getMaquina());
		
		ventaActualizado = ventaServiceImpl.actualizarVenta(ventaSeleccionado);

		return ventaActualizado;
	}

	@DeleteMapping("/ventas/{id}")
	public void borrarVenta(@PathVariable(name="id") Long id) {
		ventaServiceImpl.eliminarVenta(id);
	}

}
