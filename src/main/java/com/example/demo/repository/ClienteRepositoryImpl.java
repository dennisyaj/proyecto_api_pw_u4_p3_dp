package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Cliente;

@Transactional
@Repository
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente Cliente) {
		this.entityManager.persist(Cliente);
	}

	@Override
	public void actualizar(Cliente Cliente) {
		this.entityManager.merge(Cliente);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> query = this.entityManager
				.createQuery("SELECT a FROM Cliente a WHERE a.cedula =:cedula", Cliente.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public Cliente buscarPorID(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> buscarClientesTodos() {
		TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT a FROM Cliente a ", Cliente.class);
		return query.getResultList();
	}

	@Override
	public void borrarPorID(Integer id) {
		this.entityManager.remove(this.buscarPorID(id));
	}

	@Override
	public void borrarPorCedula(String cedula) {
		this.entityManager.remove(this.buscarPorCedula(cedula));
	}

}
