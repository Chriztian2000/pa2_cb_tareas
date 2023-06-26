package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Auto;

public interface AutoService {
	
	public void implementar(Auto auto);
	public void quitar(String placa);
	public void modificar(Auto auto);
	
//-----------------------------------------------------------------------------------------------
	public Auto buscarPorPlaca(String placa);		
	public List<Auto> buscarPorRangoDePrecio(BigDecimal precioMin , BigDecimal precioMax);
//-----------------------------------------------------------------------------------------------	
	public List<Auto> buscarPorPlacaType(String placa);
	public List<Auto> buscarPorRangoDePrecioType(BigDecimal precioMin , BigDecimal precioMax);


}
