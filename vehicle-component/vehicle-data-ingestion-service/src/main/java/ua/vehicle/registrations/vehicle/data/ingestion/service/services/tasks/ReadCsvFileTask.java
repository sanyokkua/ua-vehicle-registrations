package ua.vehicle.registrations.vehicle.data.ingestion.service.services.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.CsvUtilsService;

import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReadCsvFileTask implements Task<Optional<Path>, Stream<CSVRecord>> {
    protected final CsvUtilsService csvUtilsService;

    @Override
    public Stream<CSVRecord> process(Optional<Path> input) {
        if (input.isEmpty()) {
            return Stream.empty();
        }
        return csvUtilsService.parseCsvFile(input.get());
    }
}
