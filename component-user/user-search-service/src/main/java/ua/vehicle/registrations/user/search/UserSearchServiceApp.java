package ua.vehicle.registrations.user.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan(basePackages = {"ua.vehicle.registrations"})
@SpringBootApplication
public class UserSearchServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(UserSearchServiceApp.class, args);
    }

}
