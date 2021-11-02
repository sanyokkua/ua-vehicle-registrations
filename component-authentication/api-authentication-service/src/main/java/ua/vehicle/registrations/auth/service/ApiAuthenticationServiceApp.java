package ua.vehicle.registrations.auth.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiAuthenticationServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(ApiAuthenticationServiceApp.class, args);
	}

}
