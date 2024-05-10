package de.ba.auth.auth.controller;

import de.ba.auth.auth.controller.Services.UserService;
import de.ba.auth.auth.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saveuser")
public class SaveUserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void saveUser(@RequestBody UserEntity user) {
        userService.saveUser(user);
    }
}