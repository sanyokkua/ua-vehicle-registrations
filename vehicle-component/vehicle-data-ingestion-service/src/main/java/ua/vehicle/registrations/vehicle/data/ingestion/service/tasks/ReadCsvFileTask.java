package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ua.vehicle.registrations.vehicle.data.ingestion.service.utils.FileUtilsService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class ReadCsvFileTask implements Task<Optional<Path>, Stream<CSVRecord>> {
    protected final FileUtilsService fileUtilsService;

    @Override
    public Stream<CSVRecord> process(Optional<Path> input) {
        if (input.isPresent()) {
            var encoding = fileUtilsService.getEncoding(input.get());
            var delimiter = getDelimiter(input.get(), encoding);
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(delimiter).setSkipHeaderRecord(true).build();
            try {
                return CSVParser.parse(input.get(), Charset.forName(encoding), csvFormat).stream();
            } catch (IOException e) {
                return Stream.empty();
            }
        }
        return Stream.empty();
    }

    private char getDelimiter(@NonNull Path textFile, @NonNull String encoding) {
        try (var fileStream = Files.lines(textFile)) {
            var headerString = fileStream.findFirst().orElse(",");
            var headerStringProcessed = headerString.replace("\"", "");
            var headers = headerStringProcessed.split("\\W");
            if (headers.length > 0) {
                var firstColumn = headers[0];
                var chars = headerStringProcessed
                        .replace(firstColumn, "")
                        .substring(0, 1)
                        .toCharArray();
                return chars[0];
            }
        } catch (IOException e) {
            log.warn("Problem with recognizing delimiter", e);
        }
        return ',';
    }
}
