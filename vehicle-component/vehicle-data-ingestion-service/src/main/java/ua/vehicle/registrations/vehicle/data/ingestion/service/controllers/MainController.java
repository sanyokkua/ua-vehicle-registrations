package ua.vehicle.registrations.vehicle.data.ingestion.service.controllers;

import lombok.RequiredArgsConstructor;
import ua.vehicle.registrations.vehicle.data.ingestion.service.tasks.*;

import java.net.URL;
import java.util.List;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
public class MainController {

    private final DownloadFileTask downloadFileTask;
    private final ParseJsonPassportTask parseJsonPassportTask;
    private final UnzipFileTask unzipFileTask;
    private final ReadCsvFileTask readCsvFileTask;
    private final SendToQueueTask sendToQueueTask;
    private final DeleteFilesTask deleteFilesTask;

    public void updateRegistrationRecords(URL dataPassportJsonUrl) {
        var downloadedPassportFilePath = downloadFileTask.process(dataPassportJsonUrl);
        var parsedDataArchiveURLs = parseJsonPassportTask.process(downloadedPassportFilePath);

        parsedDataArchiveURLs.forEach(archiveUrl -> {
            var downloadedArchivePath = downloadFileTask.process(archiveUrl);
            var extractedCsvFilePath = unzipFileTask.process(downloadedArchivePath);
            var csvFile = readCsvFileTask.process(extractedCsvFilePath);
            sendToQueueTask.process(csvFile);
            deleteFilesTask.process(asList(extractedCsvFilePath.get(), downloadedArchivePath.get()));
        });
        deleteFilesTask.process(List.of(downloadedPassportFilePath.get()));

    }
}
