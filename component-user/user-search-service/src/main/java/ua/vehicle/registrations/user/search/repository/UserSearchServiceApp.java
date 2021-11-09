package ua.vehicle.registrations.user.search.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserSearchServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(UserSearchServiceApp.class, args);
    }

}
