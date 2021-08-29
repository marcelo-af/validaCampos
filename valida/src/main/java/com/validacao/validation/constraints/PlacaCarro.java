package com.validacao.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.validacao.validation.PlacaCarroValidation;

//Inicio das validações que precisa para criar a constraints
@Documented
@Constraint(validatedBy = PlacaCarroValidation.class)
//@Constraint(validateBy = PlacaCarroValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME)
//Fim das validações
public @interface PlacaCarro {	
	//Para se criar um annotation o interface deve começar com @interface
	
	String message() default "Placa de carro inválida"; //retorna mensagem
	Class<?>[] groups() default{}; //padrão validação
	Class<? extends Payload>[] payload() default{}; //padrão validação

}
