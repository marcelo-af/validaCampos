package com.validacao.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.validacao.validation.constraints.PlacaCarro;

/*O ConstraintValidator é necessário dois parametros 1 - a anotação que vai fazer a validação ou seja a classe
e no 2 - o tipo se é String,  Int entre outros. */
public class PlacaCarroValidation  implements ConstraintValidator<PlacaCarro, String>{

	@Override
    public void initialize(PlacaCarro constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
      String placa = value == null ? "" : value;
		return placa.matches("[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}");
	}

	//Os metodos initialize e isValid são implementados obrigatoriamente selecionando a opção implements method
	

}
