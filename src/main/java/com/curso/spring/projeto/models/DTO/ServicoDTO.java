package com.curso.spring.projeto.models.DTO;

public class ServicoDTO {

	private String id_cliente;
	private String descricao;
	private Double preco;
	
	public ServicoDTO() {
		
	}
	
	public ServicoDTO(String id_cliente, String descricao, Double preco) {
		this.id_cliente = id_cliente;
		this.descricao = descricao;
		this.preco = preco;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
