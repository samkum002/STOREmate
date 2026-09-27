package com.store.mate.STOREmate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "sameer12345"; // Your admin's password
        String hashedPassword = passwordEncoder.encode(rawPassword);
        
        System.out.println("Hashed Password: " + hashedPassword);
    }
}

