package com.bolsadeideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Component //la anotamos con Component para que se pueda inyectar despues en el controlador y validar 
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		Usuario usuario = (Usuario) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");
		
//		if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
//			errors.rejectValue("identificador", "pattern.usuario.identificador");
//		}
		
	}

}
