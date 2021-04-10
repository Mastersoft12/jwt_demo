package com.bancolombia.jwt_demo;

import com.bancolombia.jwt_demo.jwt.JWTUtil;
import com.bancolombia.jwt_demo.model.Role;
import com.bancolombia.jwt_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JwtDemoApplication implements CommandLineRunner {

    @Autowired
    private JWTUtil jwtUtil;

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_ADMIN);
        roles.add(Role.ROLE_USER);
        User user = new User("faamarti","123456789");
        user.setRoles(roles);
        String token = jwtUtil.generateToken(user);
        System.out.println(token);
    }
}
