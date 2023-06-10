package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U2P4CbDbApplication implements CommandLineRunner {

	@Autowired
	EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CbDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estudiante estu = new Estudiante();

		estu.setNombre("Christian");
		estu.setApellido("Betancourt");
		estu.setJobby("Jugar");
		estu.setCedula("123786890");
		//this.estudianteService.insertar(estu);
		this.estudianteService.seleccionar("123786890");
		estu.setApellido("Boada");
		estu.setNombre("David");
		estu.setJobby("basquet");
		this.estudianteService.modificar(estu);
		
		this.estudianteService.eliminar("12378689790");
		
		
		
			
	}
}
