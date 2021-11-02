package ua.vehicle.registrations.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ApiDiscoveryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiDiscoveryServiceApp.class, args);
    }

}
