package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class ParseJsonPassportTask implements Task<Optional<Path>, List<URL>> {

    @Override
    public List<URL> process(Optional<Path> input) {
        return null;
    }
}
