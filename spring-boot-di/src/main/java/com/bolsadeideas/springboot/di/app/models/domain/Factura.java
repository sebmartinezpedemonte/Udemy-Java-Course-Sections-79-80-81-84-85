package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

@Component //con solo component es singleton
@RequestScope //esto ahora dura lo que dura una peticion http de usuario
//@SessionScope //para marcar nuestro objeto como de sesion para trabajar con sesiones por ejemplo en un sitio con un carro de compras o autenticacion y tenemos la clase usuario y queremos que esta sea persistente en la sesion http utilizamos sesiones el alcance empieza cuando se inicia sesion y termina cuando cerremos el navegador o cuando ocurre un timeout o cuando  se invalida la sesion
//@ApplicationScope //es un singleton que se guarda en el servlet context y no en el application context de Spring
public class Factura implements Serializable{ //es importante implementar Serializable para el SessionScope
	
	//identificador de la serializacion
	private static final long serialVersionUID = 946004357128146951L;

	@Value("${factura.descripcion}") 
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	private List<ItemFactura> items;

	@PostConstruct //se ejecuta justo despues de que se haya creado el objeto y despues ded que se haya inyectado la dependencia
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Andrés"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
