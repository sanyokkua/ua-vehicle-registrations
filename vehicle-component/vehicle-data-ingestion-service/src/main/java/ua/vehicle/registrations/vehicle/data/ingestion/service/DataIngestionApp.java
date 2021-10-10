package ua.vehicle.registrations.vehicle.data.ingestion.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DataIngestionApp {

    public static void main(String[] args) {
        SpringApplication.run(DataIngestionApp.class, args);
    }
}
