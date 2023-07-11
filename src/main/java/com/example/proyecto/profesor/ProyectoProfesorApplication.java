package com.example.proyecto.profesor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProyectoProfesorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoProfesorApplication.class, args);
	}

}
