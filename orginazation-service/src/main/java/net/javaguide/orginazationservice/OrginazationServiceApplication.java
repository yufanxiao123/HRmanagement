package net.javaguide.orginazationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrginazationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrginazationServiceApplication.class, args);
	}

}
