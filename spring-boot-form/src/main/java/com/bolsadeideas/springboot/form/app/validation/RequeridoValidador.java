package com.bolsadeideas.springboot.form.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value== null || !StringUtils.hasText(value)) { //despues de value== null  tmb sirve: value.isEmpty() || value.isBlank()
			return false;
		}
		return true;
	}

}
