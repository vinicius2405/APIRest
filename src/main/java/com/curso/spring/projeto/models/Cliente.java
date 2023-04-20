package com.curso.spring.projeto.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.curso.spring.projeto.exceptions.CpfInvalidoException;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF", length = 11)
	private String cpf;
	
	@Column(name = "DATA_CAD")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@OneToMany(mappedBy = "cliente")
	List<Servico> servicos = new ArrayList<>();
	
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nome, String cpf, LocalDate data) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataCadastro = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.length() < 11 || cpf.length() > 11 ) {
			throw new CpfInvalidoException();
		}
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro() {
		this.dataCadastro = LocalDate.now();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
