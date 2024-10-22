package com.Micro.Estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroEstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroEstudiantesApplication.class, args);
	}

}
