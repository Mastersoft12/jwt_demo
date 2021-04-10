package com.bancolombia.jwt_demo;

import com.bancolombia.jwt_demo.jwt.JWTUtil;
import com.bancolombia.jwt_demo.model.Role;
import com.bancolombia.jwt_demo.model.User;
import com.bancolombia.jwt_demo.service.PBKDF2Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JwtDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JwtDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PBKDF2Encoder encoder = new PBKDF2Encoder();
        System.out.println("Encri: "+encoder.encode("Isabella2010$"));
        System.out.println(encoder.matches("Isabella2010$","giji4wKfTBYGhy/Q9Ah+pRoCSU1vzSORd+Vw+1Ai0G4="));

    }
}
