package ua.vehicle.registrations.vehicle.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiVehicleDataServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiVehicleDataServiceApp.class, args);
    }
}
