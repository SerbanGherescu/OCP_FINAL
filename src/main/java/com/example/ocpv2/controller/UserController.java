package com.example.ocpv2.controller;

import com.example.ocpv2.entity.User;
import com.example.ocpv2.entity.exceptions.ProductNotFoundException;
import com.example.ocpv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String addUser(@ModelAttribute User user) {
        User saveUser = userService.saveUser(user);
        return "homePage";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (id == null) {
            throw new ProductNotFoundException("Nu se gaseste utilizator cu acest id!");
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        if (email == null) {
            throw new ProductNotFoundException("Nu se gaseste utilizator cu acest email!");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "Utilizator sters cu succes!";
    }

}
