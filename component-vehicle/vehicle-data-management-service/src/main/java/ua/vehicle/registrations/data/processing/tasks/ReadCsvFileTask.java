package ua.vehicle.registrations.data.processing.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.aspects.annotations.LogInputOutput;
import ua.vehicle.registrations.aspects.annotations.LogTimeMeasures;
import ua.vehicle.registrations.data.processing.tasks.abstraction.Task;
import ua.vehicle.registrations.data.services.CsvUtilsService;

import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReadCsvFileTask implements Task<Optional<Path>, Stream<CSVRecord>> {

    protected final CsvUtilsService csvUtilsService;

    @LogInputOutput
    @LogTimeMeasures
    @Override
    public Stream<CSVRecord> process(Optional<Path> input) {
        if (input.isEmpty()) {
            return Stream.empty();
        }
        return csvUtilsService.parseCsvFile(input.get());
    }
}
