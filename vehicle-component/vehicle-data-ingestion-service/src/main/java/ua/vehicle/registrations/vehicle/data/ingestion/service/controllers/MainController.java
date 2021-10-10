package ua.vehicle.registrations.vehicle.data.ingestion.service.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.MainFlowProcessor;

import java.net.MalformedURLException;
import java.net.URL;

@Component
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final MainFlowProcessor mainFlowProcessor;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        try {
            var url = new URL("https://data.gov.ua/dataset/06779371-308f-42d7-895e-5a39833375f0/datapackage");
            mainFlowProcessor.processRegistrationData(url);
        } catch (MalformedURLException e) {
            log.warn("Problem with URL creating", e);
        }
    }
}
