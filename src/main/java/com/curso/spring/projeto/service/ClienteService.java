package com.curso.spring.projeto.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.projeto.exceptions.ClienteNaoEncontradoException;
import com.curso.spring.projeto.exceptions.CpfJaExistenteException;
import com.curso.spring.projeto.exceptions.ImpossivelExcluirException;
import com.curso.spring.projeto.models.Cliente;
import com.curso.spring.projeto.models.DTO.ClienteDTO;
import com.curso.spring.projeto.repositories.ClienteRepository;
import com.curso.spring.projeto.repositories.ServicoRespository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteReposi;
	
	@Autowired
	private ServicoRespository servicoReposi;

	public Cliente inserirCliente(Cliente cliente) {
		Cliente c = new Cliente(null, cliente.getNome(), cliente.getCpf(), LocalDate.now());
		if(clienteReposi.existsByCpf(cliente.getCpf())) {
			throw new CpfJaExistenteException(cliente.getCpf());
		}
		
		return clienteReposi.save(c);
	}

	public Cliente buscarCliente(Integer id) {
		try {
			return clienteReposi.findById(id)
					.map(x -> new Cliente(x.getId(), x.getNome(), x.getCpf(), x.getDataCadastro())).get();
		} catch (NoSuchElementException e) {
			throw new ClienteNaoEncontradoException(id);
		}

	}

	public List<Cliente> listarClientes() {
		return clienteReposi.findAll();
	}

	public void deletarCliente(Integer id) {
		if(servicoReposi.buscarPorId(id).isEmpty()) {
			Cliente cliente = new Cliente();
			cliente = this.buscarCliente(id);
			clienteReposi.delete(cliente);
		}else{
			throw new ImpossivelExcluirException(id);
		}
		
	}
	
	public Cliente editarCliente(Integer id, ClienteDTO cliente) {
		Cliente c = new Cliente();
		c = this.buscarCliente(id);
		c.setCpf(cliente.getCpf());
		c.setNome(cliente.getNome());
		return clienteReposi.save(c);
		
	}

}
