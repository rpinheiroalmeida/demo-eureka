package com.example.lab4word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4WordApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4WordApplication.class, args);
    }

}
