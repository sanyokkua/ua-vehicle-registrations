package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Slf4j
public class DeleteFilesTask implements Task<List<Path>, Void> {

    @Override
    public Void process(List<Path> filePaths) {
        filePaths.stream()
                .filter(Files::exists)
                .forEach(this::deleteFile);
        return null;
    }

    private void deleteFile(Path file) {
        try {
            Files.delete(file);
        } catch (IOException e) {
            log.warn("Problem with deleting of :" + file, e);
        }
    }

}
