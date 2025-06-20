package com.devsione.dreamwell.controller;

import com.devsione.dreamwell.dto.NewPasswordDTO;
import com.devsione.dreamwell.dto.UserDTO;
import com.devsione.dreamwell.entity.User;
import com.devsione.dreamwell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/raw")
    public ResponseEntity<List<User>> getRawUsers(){
        return ResponseEntity.ok(userService.getRawUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<UserDTO> updateEmail(
            @PathVariable UUID id,
            @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateEmail(id, userDTO));
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<UserDTO> updatePassword(
            @PathVariable UUID id,
            @RequestBody NewPasswordDTO newPasswordDTO){
        return ResponseEntity.ok(userService.updatePassword(id, newPasswordDTO));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id){
        userService.deleteUser(id);
    }
}
