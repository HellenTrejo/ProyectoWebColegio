package com.colegio.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("MENSAJE")
public class LoginController {

	
	
	@RequestMapping("/verLogin")
	public String metLogin() {
		
		return "Login";
	}
	
	
	@RequestMapping("/verLoMenu")
	public String metMenuL() {
		
		return "Menu";
	}
	
	
	
	
}
