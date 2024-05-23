package de.ba.auth.auth.config;

import de.ba.auth.auth.model.Role;
import de.ba.auth.auth.model.RoleName;
import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.RoleRepository;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

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



        if (!roleRepository.existsByName(RoleName.ROLE_USER)) {
            System.out.println("No user role was found");
            Role role = new Role();
            role.setName(RoleName.ROLE_USER);
            // Set other user properties
            roleRepository.save(role);
        }

        if (!roleRepository.existsByName(RoleName.ROLE_ADMIN)) {
            System.out.println("No ADMIN role was found");
            Role role = new Role();
            role.setName(RoleName.ROLE_ADMIN);
            // Set other user properties
            roleRepository.save(role);
        }


        if (!userRepository.existsByUsername("admin")) {
            System.out.println("No admin was found");

            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("pass"));

            user.setRoles(Collections.singleton(roleRepository.findByName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("No admin role was found"))));
            // Set other user properties
            userRepository.save(user);
        }

        if (!userRepository.existsByUsername("user")) {
            System.out.println("No user was found");
            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("pass"));



            user.setRoles(Collections.singleton(roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("No user role was found"))));
            // Set other user properties
            userRepository.save(user);
        }


    }
}
