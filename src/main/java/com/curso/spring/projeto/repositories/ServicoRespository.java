package com.curso.spring.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.spring.projeto.models.Servico;

public interface ServicoRespository extends JpaRepository<Servico, Integer>{

	
}
