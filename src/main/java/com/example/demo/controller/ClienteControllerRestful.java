package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Cliente;
import com.example.demo.service.IClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:8080")
public class ClienteControllerRestful {

	@Autowired
	private IClienteService iClienteService;

	@GetMapping(path = "/porCedula/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	Cliente buscarPorCedula(@PathVariable("cedula") String cedula) {
		return this.iClienteService.buscarPorCedula(cedula);
	}

	@PostMapping
	void insertar(@RequestBody Cliente estudiante) {
		this.iClienteService.insertar(estudiante);
	}

	@PutMapping(path = "/{id}")
	Cliente actualizar(@PathVariable("id") Integer id, @RequestBody Cliente estudiante) {
		return this.iClienteService.actualizar(id, estudiante);
	}

	@GetMapping
	List<Cliente> buscarClientesTodos() {
		return this.iClienteService.buscarTodosClientes();
	}

	@DeleteMapping(path = "/{id}")
	void borrarPorID(@PathVariable("id") Integer id) {
		this.iClienteService.borrarPorID(id);
	}

	@DeleteMapping(path = "/porCedula/{cedula}")
	void borrarPorCedula(@PathVariable("cedula") String cedula) {
		this.iClienteService.borrarPorCedula(cedula);
	}
}
