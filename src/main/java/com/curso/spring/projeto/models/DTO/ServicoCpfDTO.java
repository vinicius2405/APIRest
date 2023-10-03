package com.curso.spring.projeto.models.DTO;

public class ServicoCpfDTO {

	private String id;
	private String descricao;
	private Double valor;
	
	public ServicoCpfDTO(String id, String descricao, Double valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public ServicoCpfDTO() {
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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