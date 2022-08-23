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

import com.crud.dto.Producto;
import com.crud.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}

	@GetMapping("/productos")
	public List<Producto> listarProductos() {
		return productoServiceImpl.listarProducto();
	}

	@GetMapping("/productos/{id}")
	public Producto productoPorId(@PathVariable(name="id") Long id) {
		Producto productoPorId = new Producto();
		productoPorId = productoServiceImpl.productoPorId(id);
		
		return productoPorId;
	}	

	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id") Long id, @RequestBody Producto producto) {
		Producto productoSeleccionado = new Producto();
		Producto productoActualizado = new Producto();

		productoSeleccionado = productoServiceImpl.productoPorId(id);

		productoSeleccionado.setNombre(producto.getNombre());
		productoSeleccionado.setPrecio(producto.getPrecio());

		productoActualizado = productoServiceImpl.actualizarProducto(productoSeleccionado);

		return productoActualizado;
	}

	@DeleteMapping("/productos/{id}")
	public void borrarProducto(@PathVariable(name="id") Long id) {
		productoServiceImpl.eliminarProducto(id);
	}

}