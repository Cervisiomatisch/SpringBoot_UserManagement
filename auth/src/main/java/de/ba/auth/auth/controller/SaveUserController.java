package de.ba.auth.auth.controller;

import de.ba.auth.auth.controller.Services.UserService;
import de.ba.auth.auth.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/saveuser")
public class SaveUserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void saveUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
    }
}