package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;

import java.util.stream.Stream;

@Slf4j
public class SendToQueueTask implements Task<Stream<CSVRecord>, Void> {

    @Override
    public Void process(Stream<CSVRecord> input) {
        return null;
    }
}
