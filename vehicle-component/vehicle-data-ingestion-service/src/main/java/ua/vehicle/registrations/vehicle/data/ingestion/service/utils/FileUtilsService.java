package ua.vehicle.registrations.vehicle.data.ingestion.service.utils;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Slf4j
public class FileUtilsService {
    private static final String SYSTEM_TMP_FOLDER_PROPERTY = "java.io.tmpdir";
    private static final String APP_TMP_FOLDER = "vehicle_tmp";

    public Optional<Path> getTempDirectory() {
        var tmpFolder = System.getProperty(SYSTEM_TMP_FOLDER_PROPERTY);
        var tmpFolderPath = Paths.get(tmpFolder, APP_TMP_FOLDER);
        if (Files.exists(tmpFolderPath) && Files.isDirectory(tmpFolderPath)) {
            return Optional.of(tmpFolderPath);
        }

        var createdFolder = createFolder(tmpFolderPath);
        if (createdFolder.isEmpty()) {
            log.warn("getTempDirectory: Was the problem with creating temp directory, trying to create in the app directory");
            createdFolder = createFolder(Path.of(String.format("./%s", APP_TMP_FOLDER)));
        }
        log.info("getTempDirectory: Created folder is: {}", createdFolder.orElse(null));
        return createdFolder;
    }

    private Optional<Path> createFolder(@NonNull Path folder) {
        try {
            Files.createDirectory(folder);
            return Optional.of(folder);
        } catch (IOException e) {
            log.warn("createFolder: Was the problem with creating directory");
            return Optional.empty();
        }
    }

    public String getEncoding(@NonNull Path textFile) {
        try {
            log.debug("getEncoding: Trying to distinguish encoding of file: {}", textFile);
            return UniversalDetector.detectCharset(textFile);
        } catch (IOException e) {
            log.warn("getEncoding: Exception occurred due encoding detecting. Default value \"UTF-8\" will be returned", e);
            return "UTF-8";
        }
    }
}
