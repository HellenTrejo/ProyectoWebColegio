package com.colegio.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	
	@RequestMapping("/verMenu")
	public String metVerMenu() {
		
		return "Menu";
	}
	
}
