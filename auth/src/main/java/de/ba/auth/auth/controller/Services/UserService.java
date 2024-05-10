package de.ba.auth.auth.controller.Services;

import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    // Hier könntest du eine Datenquelle einbinden, z.B. ein UserRepository, um Benutzer aus einer Datenbank abzurufen

    // Beispiel: Annahme, dass der UserRepository existiert und Benutzer aus einer Datenbank abruft
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Beispiel: Annahme, dass der UserRepository eine Methode findAll() hat, um alle Benutzer abzurufen
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}

