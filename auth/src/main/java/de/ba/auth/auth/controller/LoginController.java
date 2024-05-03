package de.ba.auth.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
	
	@GetMapping("/")
	String redirect_login() {
		return "main";
	}	
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@GetMapping("/denied")
	String denied() {
		return "denied";
	}

	@GetMapping("/logout")
	String logout(){
		return "logout";
	}
	
	
} // EoC