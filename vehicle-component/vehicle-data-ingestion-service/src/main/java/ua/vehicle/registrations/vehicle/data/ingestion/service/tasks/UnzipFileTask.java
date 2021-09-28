package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FilenameUtils;
import ua.vehicle.registrations.vehicle.data.ingestion.service.utils.FileUtilsService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
public class UnzipFileTask implements Task<Optional<Path>, Optional<Path>> {
    protected final FileUtilsService fileUtilsService;

    @Override
    public Optional<Path> process(Optional<Path> filePath) {
        if (fileUtilsService.getTempDirectory().isEmpty()) {
            log.warn("Temp directory is not assigned. Extraction will not be executed");
            return Optional.empty();
        }
        if (filePath.isPresent()) {
            var inputFilePath = filePath.get().toString();
            var fileName = FilenameUtils.getBaseName(inputFilePath);
            var outputDirectory = fileUtilsService.getTempDirectory().get().toAbsolutePath();
            var destination = Paths.get(outputDirectory.toString(), fileName);

            try (var zipFile = new ZipFile(filePath.get().toFile())) {
                zipFile.extractAll(destination.toAbsolutePath().toString());
                return Optional.of(destination);
            } catch (IOException e) {
                log.error("extractZipArchive: Error occurred with extracting files from zip archive", e);
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
