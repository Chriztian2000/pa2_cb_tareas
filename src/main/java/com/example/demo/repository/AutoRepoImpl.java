package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Auto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutoRepoImpl implements AutoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Auto auto) {
		this.entityManager.persist(auto);

	}

	@Override
	public void eliminar(String placa) {
		Auto auto = this.buscarPorPlaca(placa);
		this.entityManager.remove(auto);

	}

	@Override
	public void actualizar(Auto auto) {
		this.entityManager.merge(auto);

	}
	
//-------------------------------------------------------------------------------------------------------------------	
	
	@Override
	public Auto buscarPorPlaca(String placa) {
		
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Auto e WHERE e.placa = :datoPlaca");
		myQuery.setParameter("datoPlaca", placa);
		return (Auto) myQuery.getSingleResult();

	}	

	@Override
	public List<Auto> buscarPorRangoDePrecio(BigDecimal precioMin, BigDecimal precioMax) {
		Query myQuery = this.entityManager
				.createQuery("SELECT e FROM Auto e WHERE e.precio BETWEEN :datoPrecioMin AND :datoPrecioMax");
		myQuery.setParameter("datoPrecioMin", precioMin);
		myQuery.setParameter("datoPrecioMax", precioMax);
		return myQuery.getResultList();
	}	

//--------------------------------------------------------------------------------------------------------------------
	
	
	@Override
	public List<Auto> buscarPorPlacaType(String placa) {
	    TypedQuery<Auto> myQuery = this.entityManager.createQuery("SELECT e FROM Auto e WHERE e.placa = :datoPlaca", Auto.class);
	    myQuery.setParameter("datoPlaca", placa);
	    List<Auto> resultList = myQuery.getResultList();

	    // Realizar el casting
	    List<Auto> autosCasteados = new ArrayList<>();
	    for (Auto auto : resultList) {
	        autosCasteados.add((Auto) auto);
	    }
	    return autosCasteados;
	}


	@Override
	public List<Auto> buscarPorRangoDePrecioType(BigDecimal precioMin, BigDecimal precioMax) {
		TypedQuery<Auto> myQuery = this.entityManager.createQuery("SELECT e FROM Auto e WHERE e.precio BETWEEN :datoPrecioMin AND :datoPrecioMax",Auto.class);
		myQuery.setParameter("datoPrecioMin", precioMin);
		myQuery.setParameter("datoPrecioMax", precioMax);
		return myQuery.getResultList();	
	
	}
	
	
	

}
