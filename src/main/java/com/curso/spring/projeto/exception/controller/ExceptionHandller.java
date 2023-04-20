package com.curso.spring.projeto.exception.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.curso.spring.projeto.exceptions.ClienteNaoEncontradoException;
import com.curso.spring.projeto.exceptions.CpfInvalidoException;

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

}
