package com.Micro.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCursosApplication.class, args);
	}

}
