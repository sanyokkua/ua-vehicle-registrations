package ua.vehicle.registrations.vehicle.data.ingestion.service.services.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.FileUtilsService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteFilesTask implements Task<List<Path>, Void> {
    protected final FileUtilsService fileUtilsService;

    @Override
    public Void process(List<Path> filePaths) {
        filePaths.stream()
                 .filter(Files::exists)
                 .forEach(fileUtilsService::deleteFile);
        return null;
    }

}
