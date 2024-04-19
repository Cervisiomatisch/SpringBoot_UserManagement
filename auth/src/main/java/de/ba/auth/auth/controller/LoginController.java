package de.ba.auth.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
	
	@GetMapping("/")
	String redirect_login() {
		return "dashboard";
	}	
	
//	@GetMapping("/login")
//	String login() {
//		return "main";
//	}
	
	@GetMapping("/denied")
	String denied() {
		return "denied";
	}	
	
	
} // EoC