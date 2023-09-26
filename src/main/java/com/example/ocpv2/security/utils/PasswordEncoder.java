package com.example.ocpv2.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rowPassword = "Admin123";
        String encodedPassword = encoder.encode(rowPassword);
        System.out.println(encodedPassword);
    }
// sa fie encodata dupa bycript encoder
}
