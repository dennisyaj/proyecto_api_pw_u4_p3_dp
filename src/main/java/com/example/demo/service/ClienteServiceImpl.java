package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.model.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	public void insertar(Cliente cliente) {
		this.iClienteRepository.insertar(cliente);
	}

	@Override
	public Cliente actualizar(Integer id, Cliente cliente) {
		cliente.setId(id);
		this.iClienteRepository.actualizar(cliente);
		return this.iClienteRepository.buscarPorID(id);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		return this.iClienteRepository.buscarPorCedula(cedula);
	}

	@Override
	public List<Cliente> buscarTodosClientes() {
		return this.iClienteRepository.buscarClientesTodos();
	}

	@Override
	public void borrarPorID(Integer id) {
		this.iClienteRepository.borrarPorID(id);
	}

	@Override
	public void borrarPorCedula(String cedula) {
		this.iClienteRepository.borrarPorCedula(cedula);
	}

}
