package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "auto")
public class Auto {
	
	@Id
	@GeneratedValue(generator = "seq_auto", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_auto", sequenceName = "seq_auto", allocationSize = 1)
	@Column(name = "auto_id")
	private Integer id;
	
	@Column(name = "auto_marca")
	private String marca;
	
	@Column(name = "auto_tipo")
	private String tipo;	
	
	@Column(name = "auto_placa")
	private String placa;
	
	@Column(name = "auto_precio")
	private BigDecimal precio;
	
	
	// GET Y SET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	
	// TOSTRING

	@Override
	public String toString() {
		return "Auto [id=" + id + ", marca=" + marca + ", tipo=" + tipo + ", placa=" + placa + ", precio=" + precio
				+ "]";
	}
	
	
	
	
	

}
