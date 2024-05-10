package de.ba.auth.auth.controller;

import de.ba.auth.auth.controller.Services.UserService;
import de.ba.auth.auth.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tableusers")
public class UserTableController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getUserData() {
        List<UserEntity> data = userService.getAllUsers();
        return data;

    }
}


