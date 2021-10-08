package ua.vehicle.registrations.vehicle.data.ingestion.service.services;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FilenameUtils;
import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Service
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

    public Optional<Path> unzip(Path filePath) {
        var tempDirectory = getTempDirectory();
        if (tempDirectory.isEmpty()) {
            log.warn("Temp directory is not assigned. Extraction will not be executed");
            return Optional.empty();
        }

        if (Objects.nonNull(filePath)) {
            var inputFilePath = filePath.toString();
            var fileName = FilenameUtils.getBaseName(inputFilePath);
            var outputDirectory = tempDirectory.get().toAbsolutePath();
            var destination = Paths.get(outputDirectory.toString(), fileName);

            try (var zipFile = new ZipFile(filePath.toFile())) {
                zipFile.extractAll(destination.toAbsolutePath().toString());
                try (Stream<Path> list = Files.list(destination)) {
                    return list.findFirst();
                }
            } catch (IOException e) {
                log.warn("extractZipArchive: Error occurred with extracting files from zip archive", e);
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    public void deleteFile(Path file) {
        try {
            Files.delete(file);
        } catch (IOException e) {
            log.warn("Problem with deleting of :" + file, e);
        }
    }

    public Optional<Path> downloadFile(@NonNull URL url) {
        var tempDirectory = getTempDirectory();
        if (tempDirectory.isEmpty()) {
            log.warn("The temporary directory is not created. Download will be skipped");
            return Optional.empty();
        }
        try {
            var fileName = FilenameUtils.getName(url.getPath());
            var targetPath = Paths.get(tempDirectory.get().toAbsolutePath().toString(), fileName);
            if (Files.notExists(targetPath, LinkOption.NOFOLLOW_LINKS)) {
                try (var inputStream = url.openStream()) {
                    Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            return Optional.of(targetPath);
        } catch (Exception e) {
            log.warn("Exception occurred. Problem with downloading file");
            return Optional.empty();
        }
    }
}
