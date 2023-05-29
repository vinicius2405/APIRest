package com.curso.spring.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.spring.projeto.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	Usuario getReferenceByLogin(String login);

}
