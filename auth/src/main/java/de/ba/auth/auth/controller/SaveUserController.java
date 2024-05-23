package de.ba.auth.auth.controller;

import de.ba.auth.auth.controller.Services.UserService;
import de.ba.auth.auth.model.CreateUserDto;
import de.ba.auth.auth.model.Role;
import de.ba.auth.auth.model.RoleName;
import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/api/admin/saveuser")
public class SaveUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    private Set<Role> roles;

    @PostMapping
    public void saveUser(@RequestBody CreateUserDto user) {

        System.out.println(user.getRoles());

        UserEntity newUser = new UserEntity();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setActive(user.getIsActive());
        newUser.setBirthday(user.getBirthday());
        newUser.setDepartment(user.getDepartment());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setRoles(Collections.singleton(roleRepository.findByName(RoleName.valueOf(user.getRoles()))
                .orElseThrow(() -> new RuntimeException("No admin role was found"))));


        userService.saveUser(newUser);
    }
}