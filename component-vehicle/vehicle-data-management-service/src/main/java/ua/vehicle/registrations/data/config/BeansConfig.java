package ua.vehicle.registrations.data.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ua.vehicle.registrations"})
public class BeansConfig {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
