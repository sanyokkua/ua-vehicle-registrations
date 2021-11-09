package ua.vehicle.registrations.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class VehicleRegistrationsServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(VehicleRegistrationsServiceApp.class, args);
    }
}
