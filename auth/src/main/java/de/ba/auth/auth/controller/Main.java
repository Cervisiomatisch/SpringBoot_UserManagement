package de.ba.auth.auth.controller;

import java.security.Principal;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import de.ba.auth.auth.controller.svc.MainManagement;
import de.ba.auth.auth.model.User;
import de.ba.auth.auth.repo.UserRepo;


@Controller
public class Main {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	MainManagement mainManagement;
	/*
	For Documentation
	@GetMapping( "/main" )
	public String getMainView(
			Model model,
			Principal principal
			) {
		
		User user = new User();
		user.setUsername("meier");
		
		userRepo.save(user);
		
		model.addAttribute("title", "MySWP");
		model.addAttribute("user", user);
		
		return "main";
	}
	*/
	@GetMapping("/main")
	public String getMain(){
		return "main";
	}

	@PostMapping( "/manageApp" )
	public ResponseEntity<JSONObject> manageApp(
			@RequestParam() String data
			) {
		
		return new ResponseEntity<JSONObject>(
				mainManagement.delegateManageApp( data ),	  
				new HttpHeaders(),
				HttpStatus.OK
				);
	}
	
	@GetMapping( "/user" )
	public String getUserView(
			) {
		return "user";
	}

	
} // EoC