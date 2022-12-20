package com.bolsadeideas.springboot.web.app.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
//import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")	//ruta de primer nivel http://localhost:8080/app/index
public class IndexController {
		
	//Inyeccion de dependencia aplicado a texto
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	//cada vez que escribamos en el navegador
	@GetMapping({"/index", "/", "", "/home"})	//http://localhost:8080/index , va a ejecutar este metodo. Si no se indica es get
	public String index(Model model) {	//si se trabaja con formularios se usa POST (value="/index" , method=RequestMethod.POST) o ponemos @PostMapping arriba del metodo 
		//pasar datos del modelo a la vista. Se puede hacer con Map, Model, ModelMap y ModelAndView
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Sebastian");
		usuario.setApellido("Martinez");
		usuario.setEmail("seba@mail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}  
	
	//si queremos utilizar este objeto en varios metodos y listas del controlador
	//le ponemos la anotacion ModelAttribute
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
		new Usuario("Sebastian", "Martinez", "seba@mail.com"),
		new Usuario("John", "Doe", "john@mail.com"),
		new Usuario("Jane", "Doe", "jane@mail.com"),
		new Usuario("Tornado", "Roe", "roe@mail.com"));
		
		return usuarios;
	}//en un proyecto real los usuarios vienen de una base de datos
	
}
