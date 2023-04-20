package com.curso.spring.projeto.exception.controller;

import java.time.Instant;

public class Erro {

	private Instant intante;
	private Integer status;
	private String erroE;
	private String msgErro;
	private String url;

	public Erro() {

	}

	public Erro(Instant intante, Integer status, String erroE, String msgErro, String url) {
		super();
		this.intante = intante;
		this.status = status;
		this.erroE = erroE;
		this.msgErro = msgErro;
		this.url = url;

	}

	public Instant getIntante() {
		return intante;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setIntante(Instant intante) {
		this.intante = intante;
	}

	public String getErroE() {
		return erroE;
	}

	public void setErroE(String erroE) {
		this.erroE = erroE;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}

}
