package ua.vehicle.registrations.vehicle.data.ingestion.service.services.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.JsonUtilsService;

import java.net.URL;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class ParseJsonPassportTask implements Task<Optional<Path>, List<URL>> {
    private final JsonUtilsService jsonUtilsService;

    @Override
    public List<URL> process(Optional<Path> input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        return jsonUtilsService.parseUrlsFromPassport(input.get());
    }
}
