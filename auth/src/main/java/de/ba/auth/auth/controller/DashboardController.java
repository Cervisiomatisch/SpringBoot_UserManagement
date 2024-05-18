package de.ba.auth.auth.controller;

import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class DashboardController {

    private UserRepository userRepository;

    @Autowired
    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }

    @GetMapping("/getAll")
    public ResponseEntity<String> getUsers() {

        List<UserEntity> userEntityList = this.userRepository.findAll();
        System.out.println(userEntityList);

        if (userEntityList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userEntityList.toString());
    }


}
