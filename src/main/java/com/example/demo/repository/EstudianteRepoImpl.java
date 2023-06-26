package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements EstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);

	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estu = this.buscar(cedula);
		this.entityManager.remove(estu);

	}

	@Override
	public Estudiante buscar(String cedula) {

		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public Estudiante seleccionarporApellido(String apellido, String nombre) {
		// SQL
		// SELECT * FROM estudiante e WHERE e.estu_apellido =
		// JPQL
		// (nombre de la clase)
		// SELECT e FROM Estudiante e WHERE e.apellido =
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante  e WHERE e.apellido = :datoApellido ");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {

		Query myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante  e WHERE e.apellido = :datoApellido AND e.nombre=:datoNombre ");

		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();

	}

	@Override
	public Estudiante seleccionarporApellidoType(String apellido) {

		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante  e WHERE e.apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

}
