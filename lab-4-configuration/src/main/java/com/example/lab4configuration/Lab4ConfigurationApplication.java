package com.example.lab4configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Lab4ConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4ConfigurationApplication.class, args);
    }

}
