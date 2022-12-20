package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	//Metodos handler controlador
@RequestMapping("/params") //esto se pone para dar una ruta base
public class EjemploParamsController {
//como enviar parametros a nuestro url mediante controladores
	
	@GetMapping("/")
	public String index() {
		
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", defaultValue="algun valor...") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto ) ;
		
		return "params/ver";
	}//http://localhost:8080/params/string?texto=Hola%20que%20tal

	//2 parametros o mas
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero ,Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'") ;
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request,Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
		numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			
		}
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'") ;
		return "params/ver";
	}
	
	
}
