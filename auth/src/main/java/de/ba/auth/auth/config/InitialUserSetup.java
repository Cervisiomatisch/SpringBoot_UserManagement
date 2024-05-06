package de.ba.auth.auth.config;

import de.ba.auth.auth.model.Role;
import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.RoleRepository;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialUserSetup implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialUserSetup(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (!userRepository.existsByUsername("admin")) {
            System.out.println("No admin was found");

            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("pass"));
            // Set other user properties
            userRepository.save(user);
        }

        if (!userRepository.existsByUsername("user")) {
            System.out.println("No user was found");
            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("pass"));
            // Set other user properties
            userRepository.save(user);
        }

        if (!roleRepository.existsByName("USER")) {
            System.out.println("No user role was found");
            Role role = new Role();
            role.setName("USER");
            // Set other user properties
            roleRepository.save(role);
        }

        if (!roleRepository.existsByName("ADMIN")) {
            System.out.println("No ADMIN role was found");
            Role role = new Role();
            role.setName("ADMIN");
            // Set other user properties
            roleRepository.save(role);
        }

        if (!roleRepository.existsByName("HR")) {
            System.out.println("No HR role was found");
            Role role = new Role();
            role.setName("HR");
            // Set other user properties
            roleRepository.save(role);
        }


    }
}
