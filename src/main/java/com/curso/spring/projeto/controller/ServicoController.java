package com.curso.spring.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.projeto.models.Servico;
import com.curso.spring.projeto.models.DTO.ServicoDTO;
import com.curso.spring.projeto.service.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {
	
	@Autowired
	ServicoService serviceS;
	
	@CrossOrigin
	@PostMapping("/inserir")
	public ResponseEntity<Servico> inserirServico(@RequestBody ServicoDTO servico ){
		return ResponseEntity.ok().body(serviceS.inserirServico(servico));
	}
	
	@CrossOrigin
	@GetMapping("/listar")
	public ResponseEntity<List<Servico>> listarServicos(){
		return ResponseEntity.ok().body(serviceS.listarServicos());
	}
	

}
