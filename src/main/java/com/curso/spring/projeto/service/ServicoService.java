package com.curso.spring.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.projeto.models.Cliente;
import com.curso.spring.projeto.models.Servico;
import com.curso.spring.projeto.models.DTO.ServicoCpfDTO;
import com.curso.spring.projeto.models.DTO.ServicoDTO;
import com.curso.spring.projeto.repositories.ClienteRepository;
import com.curso.spring.projeto.repositories.ServicoRespository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRespository servicoR;
	
	@Autowired
	private ClienteRepository clienteR;
	
	public Servico inserirServico(ServicoCpfDTO servico) {
		Cliente c = new Cliente();
		c = clienteR.buscaPorCpf(servico.getId());
		
		Servico servicos = new Servico(null,servico.getDescricao(),servico.getValor(),c);
		servicoR.save(servicos);
		return servicos;
	}
	
	public List<Servico> listarServicos(){
		return servicoR.findAll();
	}
	
	
	
	public List<ServicoDTO>listarServicosCPF(String cpf){
		return servicoR.buscaServicoCpf(cpf);
	}

}
