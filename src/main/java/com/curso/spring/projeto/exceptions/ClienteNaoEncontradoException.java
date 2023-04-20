package com.curso.spring.projeto.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
		public ClienteNaoEncontradoException(Object id) {
			super("O cliente com o id: " + id + "Não foi encontrado");
		}
}
