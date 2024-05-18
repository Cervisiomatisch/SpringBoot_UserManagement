package de.ba.auth.auth.repo;

import de.ba.auth.auth.model.Role;
import de.ba.auth.auth.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName name);
    Boolean existsByName(String name);
}
