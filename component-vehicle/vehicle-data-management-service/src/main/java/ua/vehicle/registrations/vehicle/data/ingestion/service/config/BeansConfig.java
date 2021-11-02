package ua.vehicle.registrations.vehicle.data.ingestion.service.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
