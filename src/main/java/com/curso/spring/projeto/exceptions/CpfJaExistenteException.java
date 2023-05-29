package com.curso.spring.projeto.exceptions;

public class CpfJaExistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CpfJaExistenteException(Object id) {
		super("Cpf já existente " + id);
		
	}
	
}
