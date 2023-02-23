package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Cliente;

public interface IClienteRepository {

	Cliente buscarPorCedula(String cedula);

	Cliente buscarPorID(Integer id);

	void insertar(Cliente cliente);

	void actualizar(Cliente cliente);

	List<Cliente> buscarClientesTodos();

	void borrarPorID(Integer id);

	void borrarPorCedula(String cedula);

}
