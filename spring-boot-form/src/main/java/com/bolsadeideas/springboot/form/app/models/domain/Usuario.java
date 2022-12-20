package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

//import javax.validation.Valid;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
//import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

import com.bolsadeideas.springboot.form.app.validation.IdentificadorRegex;
import com.bolsadeideas.springboot.form.app.validation.Requerido;

//Clase Entity o POJO
public class Usuario {
	 
	//expresiones regulares
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") //cualquier caracter de 0 a 9, pero que sean 2 caracteres, seguido de un punto y luego de cualquier caracter de 0-9 pero que sean 3, seguido de un punto y luego de cualquier caracter de 0-9 pero que sean 3, seguido por un guion, seguido por cualquier caracter de la A a la Z pero 1 caracter  
	@IdentificadorRegex
	private String identificador; //vamos a validarlo de forma personalizada con una anotacion propia creada por nosotros
	
	//@NotEmpty(message = "el nombre no puede ser vacio")
	//@NotEmpty vamos a validarlo de forma personalizada con una clase llamada UsuarioValidador en el paquete validations
	private String nombre;
	
	//@NotEmpty//personalizamos los mensajes en el archivo messages.properties
	@Requerido
	private String apellido;

	//Validando con Spring
	@NotBlank //para que no pueda ser espacios en blanco o sin nada 
	@Size(min = 3, max=8)
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	//@Email(message = "correo con formato incorrecto")
	@Email
	private String email;

	@NotNull//para objetos
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	
	@NotNull
	@Past
	//@FutureOrPresent
	//@Future
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	
	@NotNull
	private Pais pais;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	@NotEmpty
	private String valorSecreto;
	
	public String getValorSecreto() {
		return valorSecreto;
	}

	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificador() {
		return identificador;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
