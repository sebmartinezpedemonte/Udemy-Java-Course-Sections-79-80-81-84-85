package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.services.IServicio;


@Controller
public class IndexController {

	 //inyeccion de dependencia
	//@Qualifier("miServicioComplejo") //Permite seleccionar tambien a traves del nombre el componente especifico que implementa la interfaz
	@Autowired
	@Qualifier("miServicioComplejo")
	private IServicio servicio; //cuanto mas generico mejor, usar interfaces
	
	//Podemnos inyectar mediante atributo, metodo set y constructor (usando el @Autowired)
	
	/*
	@Autowired Tambien podemos poner el autowired en el constructor e incluso es implicito
	public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}*/

	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

	/*
	@Autowired puedo poner el Autowired aca en vez de arriba del atributo
	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}*/
	
	
	
}
