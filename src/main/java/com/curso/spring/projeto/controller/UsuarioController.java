package com.curso.spring.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.projeto.models.Usuario;
import com.curso.spring.projeto.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	
	@CrossOrigin
	@PostMapping("/inserir")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void inserirUsuario(@RequestBody Usuario usuario) {
			service.criarUsuario(usuario);
	}
	
	@CrossOrigin
	@GetMapping("/buscar/{login}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable String login){
		return ResponseEntity.ok().body(service.buscarUsuario(login));
	}
	
}
