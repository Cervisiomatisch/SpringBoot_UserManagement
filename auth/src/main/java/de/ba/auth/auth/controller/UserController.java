package de.ba.auth.auth.controller;

import de.ba.auth.auth.controller.Services.UserService;
import de.ba.auth.auth.dto.CreateUserDto;
import de.ba.auth.auth.dto.TableUserDto;
import de.ba.auth.auth.dto.UpdateUserDto;
import de.ba.auth.auth.model.Role;
import de.ba.auth.auth.model.RoleName;
import de.ba.auth.auth.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    private Set<Role> roles;

    @PostMapping("createuser")
    public void createUser(@RequestBody CreateUserDto user) {

        userService.createUser(user);
    }

    @PutMapping("updateuser")
    public void updateUser(@RequestBody UpdateUserDto user) {

        userService.updateUser(user);
    }
}