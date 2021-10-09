package ua.vehicle.registrations.vehicle.data.ingestion.service.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.tasks.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final DownloadFileTask downloadFileTask;
    private final ParseJsonPassportTask parseJsonPassportTask;
    private final UnzipFileTask unzipFileTask;
    private final ReadCsvFileTask readCsvFileTask;
    private final PersistRecordsTask persistRecordsTask;
    private final DeleteFilesTask deleteFilesTask;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        try {
            var url = new URL("https://data.gov.ua/dataset/06779371-308f-42d7-895e-5a39833375f0/datapackage");
            updateRegistrationRecords(url);
        } catch (MalformedURLException e) {
            log.warn("Problem with URL creating", e);
        }
    }


    public void updateRegistrationRecords(URL dataPassportJsonUrl) {
        var downloadedPassportFilePath = downloadFileTask.process(dataPassportJsonUrl);
        log.info("downloadedPassportFilePath -> {}", downloadedPassportFilePath.orElse(null));
        var parsedDataArchiveURLs = parseJsonPassportTask.process(downloadedPassportFilePath);
        log.info("parsedDataArchiveURLs -> {}", parsedDataArchiveURLs);

        parsedDataArchiveURLs.forEach(archiveUrl -> {
            var downloadedArchivePath = downloadFileTask.process(archiveUrl);
            log.info("downloadedArchivePath -> {}", downloadedArchivePath.orElse(null));
            var extractedCsvFilePath = unzipFileTask.process(downloadedArchivePath);
            log.info("extractedCsvFilePath -> {}", extractedCsvFilePath.orElse(null));
            var csvFile = readCsvFileTask.process(extractedCsvFilePath);
            log.info("csvFile -> {}", csvFile);

            LocalTime timeBefore = LocalTime.now();
            persistRecordsTask.process(csvFile);
            LocalTime timeAfter = LocalTime.now();
            log.info("Start time: {}, End time: {}, diff: {}", timeBefore, timeAfter, ChronoUnit.SECONDS.between(timeBefore, timeAfter));

            var filesToBeDeleted = new ArrayList<Path>();
            extractedCsvFilePath.ifPresent(filesToBeDeleted::add);
            downloadedArchivePath.ifPresent(filesToBeDeleted::add);
            log.info("Files to be deleted -> {}", filesToBeDeleted);
            deleteFilesTask.process(filesToBeDeleted);
        });

        downloadedPassportFilePath.ifPresent(path -> deleteFilesTask.process(List.of(path)));
    }
}
