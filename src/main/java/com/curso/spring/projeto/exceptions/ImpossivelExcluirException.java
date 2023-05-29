package com.curso.spring.projeto.exceptions;

public class ImpossivelExcluirException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ImpossivelExcluirException(Object id) {
		super("Cliente com dados atrelados, não pode ser excluida");
	}

}
