package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.AggregateCsvRegistrationRecordHandler;
import ua.vehicle.registrations.vehicle.data.ingestion.service.processing.tasks.abstraction.Task;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.CsvUtilsService;

import java.util.Optional;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class PersistRecordsTask implements Task<Stream<CSVRecord>, Void> {

    private final AggregateCsvRegistrationRecordHandler aggregateCsvRegistrationRecordHandler;
    private final CsvUtilsService csvUtilsService;

    @Override
    public Void process(Stream<CSVRecord> input) {
        input.parallel()
             .map(csvUtilsService::mapCsvRecordToVehicleRegistrationRecord)
             .filter(Optional::isPresent)
             .map(Optional::get)
             .forEach(aggregateCsvRegistrationRecordHandler::handleMessage);
        return null;
    }
}
