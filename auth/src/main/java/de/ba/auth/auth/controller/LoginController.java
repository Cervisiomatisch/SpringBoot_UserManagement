package de.ba.auth.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }


}
