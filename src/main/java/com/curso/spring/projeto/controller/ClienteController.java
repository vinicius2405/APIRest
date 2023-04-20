package com.curso.spring.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.projeto.models.Cliente;
import com.curso.spring.projeto.models.DTO.ClienteDTO;
import com.curso.spring.projeto.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clientes;

	@CrossOrigin
	@PostMapping("/inserir")
	public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(clientes.inserirCliente(cliente));
	}
	
	@CrossOrigin
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id){
		return ResponseEntity.ok().body(clientes.buscarCliente(id));
	}
	
	@CrossOrigin
	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarCliente(){
		return ResponseEntity.ok().body(clientes.listarClientes());
	}
	
	@CrossOrigin
	@DeleteMapping("/deletar/{id}")
	public void deletarCliente(@PathVariable Integer id) {
		clientes.deletarCliente(id);
	}
	
	@CrossOrigin
	@PutMapping("/editar/{id}")
	public ResponseEntity<Cliente> editarCliente(@PathVariable Integer id, @RequestBody ClienteDTO cliente){
		return ResponseEntity.ok().body(clientes.editarCliente(id,cliente));      
		
	}

}
