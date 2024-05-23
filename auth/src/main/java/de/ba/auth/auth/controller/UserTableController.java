package de.ba.auth.auth.controller;

import de.ba.auth.auth.controller.Services.UserService;
import de.ba.auth.auth.dto.TableUserDto;
import de.ba.auth.auth.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/tableusers")
public class UserTableController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<TableUserDto> getUserData() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public TableUserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        boolean isRemoved = userService.deleteUser(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
