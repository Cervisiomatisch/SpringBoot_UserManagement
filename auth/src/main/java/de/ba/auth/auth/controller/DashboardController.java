package de.ba.auth.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard(){
        return "dashboard";
    }

    @GetMapping("/dashboard/users")
    public String getUsers(){

        // get method to retrieve user data from database
        return null;
    }
}
