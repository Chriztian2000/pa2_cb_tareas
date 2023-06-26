package com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Auto;
import com.example.demo.service.AutoService;

@SpringBootApplication
public class Pa2U2P4CbDbApplication implements CommandLineRunner {

	@Autowired
	private AutoService autoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4CbDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Auto auto1 = new Auto();
		auto1.setMarca("KIA");
		auto1.setPlaca("PCK6693");
		auto1.setTipo("MANUAL");
		auto1.setPrecio(new BigDecimal(25000));

		Auto auto2 = new Auto();
		auto2.setMarca("KIA");
		auto2.setPlaca("PQW1234");
		auto2.setTipo("MANUAL");
		auto2.setPrecio(new BigDecimal(20000));

		Auto auto3 = new Auto();
		auto3.setMarca("CHEVROLET");
		auto3.setPlaca("PFI0987");
		auto3.setTipo("AUTOMATICO");
		auto3.setPrecio(new BigDecimal(10000));

		Auto auto4 = new Auto();
		auto4.setMarca("MERCEDES");
		auto4.setPlaca("PLM5678");
		auto4.setTipo("MANUAL");
		auto4.setPrecio(new BigDecimal(22000));

		Auto auto5 = new Auto();
		auto5.setMarca("TOYOTA");
		auto5.setPlaca("PVG6655");
		auto5.setTipo("AUTOMATICO");
		auto5.setPrecio(new BigDecimal(15000));

		/*
		 * this.autoService.implementar(auto1); this.autoService.implementar(auto2);
		 * this.autoService.implementar(auto3); this.autoService.implementar(auto4);
		 * this.autoService.implementar(auto5);
		 */

		System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("RESULTADO QUERY CON SINGLERESULT");
		// this.autoService.buscarPorPlaca("PCK6693");
		System.out.println(this.autoService.buscarPorPlaca("PCK6693"));

		System.out.println("RESULTADO QUERY CON RESULTLIST");
		List<Auto> autosEnRango = autoService.buscarPorRangoDePrecio(new BigDecimal(20000), new BigDecimal(25000));
		for (Auto auto : autosEnRango) {
			System.out.println(auto);
		}
		
		
		System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("RESULTADO TYPEDQUERY CON SINGLERESULT");
		System.out.println(this.autoService.buscarPorPlacaType("PLM5678"));
		
		System.out.println("RESULTADO TYPEDQUERY CON RESULTLIST");
		List<Auto> autosEnRangoTyped = autoService.buscarPorRangoDePrecioType(new BigDecimal(0), new BigDecimal(19000));
		for (Auto autotyped : autosEnRangoTyped) {
			System.out.println(autotyped);
		}
		System.out.println("");

	}
}
