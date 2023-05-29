package com.curso.spring.projeto.exception.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.curso.spring.projeto.exceptions.ClienteNaoEncontradoException;
import com.curso.spring.projeto.exceptions.CpfInvalidoException;
import com.curso.spring.projeto.exceptions.CpfJaExistenteException;
import com.curso.spring.projeto.exceptions.ImpossivelExcluirException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandller {

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<Erro> ClienteNaoEncontradoException(ClienteNaoEncontradoException e, HttpServletRequest request) {
		String msgErro = "Cliente não encontrado";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Erro erro = new Erro(Instant.now(), status.value(),msgErro,e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status.value()).body(erro);
	}
	
	@ExceptionHandler(CpfInvalidoException.class)
	public ResponseEntity<Erro>CpfInvalidoException(CpfInvalidoException e, HttpServletRequest request){
		String msgErro = "CPF inválido";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Erro erro = new Erro(Instant.now(), status.value(), e.getMessage(), msgErro, request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}

	@ExceptionHandler(CpfJaExistenteException.class)
	public ResponseEntity<Erro>CpfJaExistenteException(CpfJaExistenteException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String mensagem = "Cpf já cadastrado";
		Erro erro = new Erro(Instant.now(),status.value(),e.getMessage(),mensagem,request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
	@ExceptionHandler(ImpossivelExcluirException.class)
	public ResponseEntity<Erro>CpfJaExistenteException(ImpossivelExcluirException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String mensagem = "Não foi possível excluir";
		Erro erro = new Erro(Instant.now(),status.value(),e.getMessage(),mensagem,request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
		
	}
}
