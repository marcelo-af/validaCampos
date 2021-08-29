package com.validacao.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.validacao.model.ClienteModel;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@PostMapping("/salvar")
	private ResponseEntity<String> salvar(@RequestBody @Valid ClienteModel cliente){
		return ResponseEntity.ok("Salvo com sucesso");
	}

	
	//Metodo de tratamento para as exceções 
	@ResponseStatus(HttpStatus.BAD_REQUEST) //trata as exceções de bad request
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		
		//pega a exceção e captura as informacoes que estao dentro dela 
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			
			//coloca na lista o nome do campo e a mensagem de erro retornadas no foreach
			errors.put(fieldName, errorMessage);
		});
		
		
		return errors;
	}
}
