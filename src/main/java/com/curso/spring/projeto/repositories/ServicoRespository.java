package com.curso.spring.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.projeto.models.Servico;
import com.curso.spring.projeto.models.DTO.ServicoDTO;

public interface ServicoRespository extends JpaRepository<Servico, Integer>{

	
	@Query("SELECT new com.curso.spring.projeto.models.DTO.ServicoDTO("
			+ " s.id, s.descricao,s.valor)"
			+ " FROM Cliente c, Servico s "
			+ " WHERE c.id = s.cliente.id "
			+ " and c.cpf = ?1")
	List<ServicoDTO> buscaServicoCpf(String cpf);
	
	
	@Query("SELECT new com.curso.spring.projeto.models.DTO.ServicoDTO("
			+ " s.id, s.descricao,s.valor)"
			+ " FROM Cliente c, Servico s "
			+ " WHERE c.id = s.cliente.id "
			+ " and c.id = ?1")
	List<ServicoDTO> buscarPorId(Integer id);
	
}
