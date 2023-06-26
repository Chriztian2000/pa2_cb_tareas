package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Auto;

public interface AutoRepo {
	
	public void insertar(Auto auto);
	public void eliminar(String placa);
	public void actualizar(Auto auto);
//-----------------------------------------------------------------------------------------
	public Auto buscarPorPlaca(String placa);		
	public List<Auto> buscarPorRangoDePrecio(BigDecimal precioMin , BigDecimal precioMax);
//-----------------------------------------------------------------------------------------
	public List<Auto> buscarPorPlacaType(String placa);
	public List<Auto> buscarPorRangoDePrecioType(BigDecimal precioMin , BigDecimal precioMax);
	
	

}
