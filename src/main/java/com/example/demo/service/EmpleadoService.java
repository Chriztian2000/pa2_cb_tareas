package com.example.demo.service;

import com.example.demo.repository.modelo.Empleado;

public interface EmpleadoService {
	
	public void ingresar(Empleado empleado);
	
	public void modificar(Empleado empleado);
	public Empleado encontrar(Integer id);
	public void quitar(Integer id);

}