package de.ba.auth.auth.controller;

import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserTableController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tableuser")
    public List<UserEntity> getUserData() {
        List<UserEntity> data = userRepository.findAll();
        System.out.println(data);
        return data;
    }
}

