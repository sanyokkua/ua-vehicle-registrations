package ua.vehicle.registrations.user.management.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserManagementServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementServiceApp.class, args);
    }

}
