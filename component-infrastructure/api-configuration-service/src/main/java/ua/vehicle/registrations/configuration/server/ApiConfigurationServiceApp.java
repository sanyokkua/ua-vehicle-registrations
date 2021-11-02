package ua.vehicle.registrations.configuration.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ApiConfigurationServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiConfigurationServiceApp.class, args);
    }

}
