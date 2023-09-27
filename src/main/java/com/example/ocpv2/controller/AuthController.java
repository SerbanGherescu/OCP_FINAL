package com.example.ocpv2.controller;

import com.example.ocpv2.entity.Role;
import com.example.ocpv2.entity.User;
import com.example.ocpv2.repository.RoleRepository;
import com.example.ocpv2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // create model object to store form data
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") User user,
                               BindingResult result) {

        if (result.hasErrors()) {
            // pop retry register
            return "register";
        } else {
            User existingUser = userService.findUserByEmail(user.getEmail());
            if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
                result.rejectValue("email", null,
                        "Exista deja un cont creat cu aceasta adresa de email!");
                return "redirect:/register?error";
            } else {

                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String encodedPassword = encoder.encode(user.getPassword());

                user.setPassword(encodedPassword);
                userService.saveUser(user);

            }

            return "redirect:/register?success";
        }
    }

//    // handler method to handle list of users
//    @GetMapping("/users")
//    public String users(Model model){
//        List<UserDto> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "users";
//    }


}