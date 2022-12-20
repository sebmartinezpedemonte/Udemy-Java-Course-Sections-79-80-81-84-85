package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Home() {	//en vez de retornar el nombre de una vista retornamos una ruta
		return "forward:/app/index";	//"redirect:/app/index" dirige a http://localhost:8080/app/index o podemos ir a cualquier pagina web como "redirect:https://www.google.com"
	}//"forward:/app/index" con forward la ruta se mantiene intacta (queda asi: http://localhost:8080/)
	
}
