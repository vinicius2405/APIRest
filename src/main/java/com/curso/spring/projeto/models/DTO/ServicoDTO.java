package com.curso.spring.projeto.models.DTO;

public class ServicoDTO {

	private Integer id;
	private String descricao;
	private Double valor;
	
	public ServicoDTO(Integer id, String descricao, Double valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public ServicoDTO() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
//criar outro DTO 
}
