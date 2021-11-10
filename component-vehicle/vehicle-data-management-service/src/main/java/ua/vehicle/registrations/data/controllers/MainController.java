package ua.vehicle.registrations.data.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.aspects.annotations.LogInputOutput;
import ua.vehicle.registrations.aspects.annotations.LogTimeMeasures;
import ua.vehicle.registrations.data.processing.MainFlowProcessor;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainController {

    private final MainFlowProcessor mainFlowProcessor;
    @Value("${app.dataingestion.data.url}")
    private String dataUrl;

    @LogInputOutput
    @LogTimeMeasures
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        try {
            var url = new URL(dataUrl);
            mainFlowProcessor.processRegistrationData(url);
        } catch (MalformedURLException e) {
            log.warn("Problem with URL creating", e);
        }
    }
}
