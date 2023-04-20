package com.curso.spring.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.projeto.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
	@Query("SELECT new com.curso.spring.projeto.models.Cliente("
			+ " id, nome, cpf, dataCadastro) "
			+ " FROM Cliente c"
			+ " WHERE c.cpf = ?1")
	Cliente buscaPorCpf(String cpf);

}
