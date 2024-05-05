package de.ba.auth.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }
}
