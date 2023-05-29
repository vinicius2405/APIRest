package com.curso.spring.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.projeto.models.Usuario;
import com.curso.spring.projeto.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	
	public void criarUsuario(Usuario usuario) {
		repositorio.save(usuario);
	}
	
	
	public Usuario buscarUsuario(String login) {
		return repositorio.getReferenceByLogin(login);
	}

}
