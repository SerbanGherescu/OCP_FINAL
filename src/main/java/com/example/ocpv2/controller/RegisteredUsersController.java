package com.example.ocpv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisteredUsersController {
    @GetMapping("/products")
    public String registeredUsersPage() {
        return "products"; // Return the name of your Thymeleaf template for this page
    }

}