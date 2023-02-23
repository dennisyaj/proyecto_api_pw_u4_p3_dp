package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Cliente;

public interface IClienteService {

	void insertar(Cliente cliente);

	Cliente actualizar(Integer id,Cliente cliente);

	Cliente buscarPorCedula(String cedula);

	List<Cliente> buscarTodosClientes();

	void borrarPorID(Integer id);

	void borrarPorCedula(String cedula);
	
}
