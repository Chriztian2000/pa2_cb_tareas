package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AutoRepo;
import com.example.demo.repository.modelo.Auto;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	private AutoRepo autoRepo;

	@Override
	public void implementar(Auto auto) {
		this.autoRepo.insertar(auto);
	}

	@Override
	public void quitar(String placa) {
		this.autoRepo.eliminar(placa);
	}

	@Override
	public void modificar(Auto auto) {
		this.autoRepo.actualizar(auto);
	}

//-----------------------------------------------------------------------------------------------

	@Override
	public Auto buscarPorPlaca(String placa) {
		return this.autoRepo.buscarPorPlaca(placa);
	}

	@Override
	public List<Auto> buscarPorRangoDePrecio(BigDecimal precioMin, BigDecimal precioMax) {
		return this.autoRepo.buscarPorRangoDePrecio(precioMin, precioMax);
	}

//-----------------------------------------------------------------------------------------------

	@Override
	public List<Auto> buscarPorPlacaType(String placa) {
		return this.autoRepo.buscarPorPlacaType(placa);
	}

	@Override
	public List<Auto> buscarPorRangoDePrecioType(BigDecimal precioMin, BigDecimal precioMax) {
		return this.buscarPorRangoDePrecio(precioMin, precioMax);
	}

}
