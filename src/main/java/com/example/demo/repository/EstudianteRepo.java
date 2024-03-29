package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepo {
	public void insertar(Estudiante estudiante);
	public Estudiante buscar (String cedula);
	public void eliminar(String cedula);
	public void actualizar(Estudiante estudiante);
	
	public Estudiante seleccionarporApellido (String apellido,String nombre);
	public Estudiante seleccionarporApellidoType (String apellido);

	public List<Estudiante> seleccionarListaPorApellido(String apellido); 
}
