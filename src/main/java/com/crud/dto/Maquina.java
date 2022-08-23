package com.crud.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="maquinas")
public class Maquina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "piso")
	private int piso;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "maquina")
    private List<Venta> ventas;
	
	public Maquina() {
	
	}

	public Maquina(Long id, int piso, List<Venta> ventas) {
		this.id = id;
		this.piso = piso;
		this.ventas = ventas;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	
	
	
	@Override
	public String toString() {
		return "Maquina [id=" + id + ", piso=" + piso + ", ventas=" + ventas + "]";
	}
}



