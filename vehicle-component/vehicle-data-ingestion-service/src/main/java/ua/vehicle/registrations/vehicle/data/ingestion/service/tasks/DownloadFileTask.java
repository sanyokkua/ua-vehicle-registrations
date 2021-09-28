package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import ua.vehicle.registrations.vehicle.data.ingestion.service.utils.FileUtilsService;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class DownloadFileTask implements Task<URL, Optional<Path>> {
    protected final FileUtilsService fileUtilsService;

    @Override
    public Optional<Path> process(URL url) {
        var tmpDir = fileUtilsService.getTempDirectory();
        if (tmpDir.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(processDownload(url, tmpDir.get()));
    }

    private Path processDownload(@NonNull URL url, @NonNull Path tmpDir) {
        try {
            var fileName = FilenameUtils.getName(url.getPath());
            var targetPath = Paths.get(tmpDir.toAbsolutePath().toString(), fileName);
            try (var in = url.openStream()) {
                Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
            return targetPath;
        } catch (Exception e) {
            log.warn("Exception occurred. Problem with downloading file");
            return null;
        }
    }
}
