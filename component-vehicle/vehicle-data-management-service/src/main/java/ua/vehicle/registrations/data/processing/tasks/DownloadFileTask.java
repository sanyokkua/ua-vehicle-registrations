package ua.vehicle.registrations.data.processing.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.aspects.annotations.LogInputOutput;
import ua.vehicle.registrations.aspects.annotations.LogTimeMeasures;
import ua.vehicle.registrations.data.processing.tasks.abstraction.Task;
import ua.vehicle.registrations.data.services.FileUtilsService;

import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class DownloadFileTask implements Task<URL, Optional<Path>> {

    protected final FileUtilsService fileUtilsService;

    @LogInputOutput
    @LogTimeMeasures
    @Override
    public Optional<Path> process(URL url) {
        if (Objects.isNull(url)) {
            log.warn("URL is null. Skipping download task");
            return Optional.empty();
        }
        return fileUtilsService.downloadFile(url);
    }
}
