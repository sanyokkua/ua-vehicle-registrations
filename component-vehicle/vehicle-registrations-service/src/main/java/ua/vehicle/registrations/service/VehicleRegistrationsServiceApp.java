package ua.vehicle.registrations.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.vehicle.registrations.RestBaseConfig;

@EnableDiscoveryClient
@ComponentScan(basePackages = {"ua.vehicle.registrations"})
@EntityScan("ua.vehicle.registrations.service.db.entities")
@EnableJpaRepositories("ua.vehicle.registrations.service.db.repositories")
@ImportAutoConfiguration(classes = {RestBaseConfig.class})
@SpringBootApplication
public class VehicleRegistrationsServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(VehicleRegistrationsServiceApp.class, args);
    }
}
