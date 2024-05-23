package de.ba.auth.auth.controller.Services;

import de.ba.auth.auth.dto.CreateUserDto;
import de.ba.auth.auth.dto.TableUserDto;
import de.ba.auth.auth.dto.UpdateUserDto;
import de.ba.auth.auth.model.RoleName;
import de.ba.auth.auth.model.UserEntity;
import de.ba.auth.auth.repo.RoleRepository;
import de.ba.auth.auth.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<TableUserDto> getAllUsers() {
        List<UserEntity> entities =  userRepository.findAll();
        List<TableUserDto> dtos = new ArrayList<>();

        for (UserEntity entity : entities) {
            TableUserDto dto  = new TableUserDto();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(passwordEncoder.encode(entity.getPassword()));
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setDepartment(entity.getDepartment());
            dto.setIsActive(entity.getIsActive());

            dto.setRoles(entity.getRoles().stream().findFirst().get().getName().name());



            dtos.add(dto);
        }

        return dtos;
    }

    public TableUserDto getUserById(Integer id) {

        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Benutzer nicht gefunden für ID: " + id));


        TableUserDto dto  = new TableUserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(passwordEncoder.encode(entity.getPassword()));
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDepartment(entity.getDepartment());
        dto.setIsActive(entity.getIsActive());

        dto.setRoles(entity.getRoles().stream().findFirst().get().getName().name());


        return dto;
    }
    public boolean deleteUser(Integer id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    public void createUser(CreateUserDto user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setDepartment(user.getDepartment());
        entity.setIsActive(user.getIsActive());

        entity.setRoles(Collections.singleton(roleRepository.findByName(RoleName.valueOf(user.getRoles()))));


        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(entity);
    }

    public void updateUser(UpdateUserDto user) {


        UserEntity entity = userRepository.findById(user.getId()).get();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setDepartment(user.getDepartment());
        entity.setIsActive(user.getIsActive());



        entity.setRoles(Collections.singleton(roleRepository.findByName(RoleName.valueOf(user.getRoles()))));

        userRepository.save(entity);
    }
}

