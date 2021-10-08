package ua.vehicle.registrations.vehicle.data.ingestion.service.services.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.FileUtilsService;

import java.nio.file.Path;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class UnzipFileTask implements Task<Optional<Path>, Optional<Path>> {
    protected final FileUtilsService fileUtilsService;

    @Override
    public Optional<Path> process(Optional<Path> filePath) {
        if (filePath.isEmpty()) {
            return Optional.empty();
        }
        return fileUtilsService.unzip(filePath.get());
    }
}
