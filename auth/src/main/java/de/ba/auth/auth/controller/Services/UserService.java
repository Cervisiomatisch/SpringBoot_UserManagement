package de.ba.auth.auth.controller.Services;

import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benutzer nicht gefunden für ID: " + id));
    }
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
}

