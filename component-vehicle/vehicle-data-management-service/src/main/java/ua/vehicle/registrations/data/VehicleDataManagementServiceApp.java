package ua.vehicle.registrations.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@EnableCaching
@ComponentScan(basePackages = {"ua.vehicle.registrations"})
@SpringBootApplication
public class VehicleDataManagementServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(VehicleDataManagementServiceApp.class, args);
    }
}
