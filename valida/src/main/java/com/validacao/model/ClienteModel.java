package com.validacao.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.validacao.validation.constraints.PlacaCarro;

import lombok.Data;

@Data
public class ClienteModel {
	
//Algumas anotations
//@NotNull não permite valor nulo porem permite espaço em branco
//@NotEmpty não permite valor vazio porem permite espaço em branco
//@NotBlank não permite espaço em branco, geralmente o @NotBlank e @NotEmpty não é utilizado para Integer. 
//Em Integer utiliza o @NotNull	
	
	private Integer id;
	
	//O @Pattern serve para fazer uma expressão regular
	@NotBlank(message = "Campo não informado")	
	@Pattern(regexp = "^[A-Z]+(.)*", message = "O nome deve inciar com uma letra Maiúscula.")
	private String nome;
	
	@Email(message = "Campo inválido")
	@NotBlank(message = "Campo não informado")	
	private String email;
	
	@CPF(message = "Campo inválido")
	@NotBlank(message = "Campo não informado")	
	private String cpf;
	
	@NotBlank(message = "Campo não informado")	
	@PlacaCarro(message = "Campo inválido")
	private String placaCarro;
	
	//Teste referente ao ano de nascimento opcional
	@NotNull
	@Min(value = 1900, message="Ano de nascimento deve ser maior que 1899")
	private Integer anoNascimento;
	
	
	//Curiosidade: Nessa versão do java (SpringToolSuite4) o lombok não é aceito por isso tem que fazer os getters e setters na model

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public Integer getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	
	

}
