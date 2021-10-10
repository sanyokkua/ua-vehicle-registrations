package ua.vehicle.registrations.vehicle.data.ingestion.service.services;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.RegistrationPassportDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.RegistrationPassportItemDto;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonUtilsService {

    private final Gson gson;
    private final FileUtilsService fileUtilsService;

    public List<URL> parseUrlsFromPassport(Path input) {
        if (Objects.isNull(input)) {
            return Collections.emptyList();
        }
        var jsonText = getTextFromFile(input);
        if (jsonText.isEmpty()) {
            return Collections.emptyList();
        }
        return parseJson(jsonText.get());
    }

    private List<URL> parseJson(String jsonText) {
        var passportDto = Optional.ofNullable(gson.fromJson(jsonText, RegistrationPassportDto.class));
        return passportDto.isEmpty() ?
                Collections.emptyList() :
                passportDto.get()
                           .getResources()
                           .stream()
                           .map(RegistrationPassportItemDto::getPath)
                           .map(this::getUrl)
                           .filter(Optional::isPresent)
                           .map(Optional::get)
                           .collect(Collectors.toList());
    }

    private Optional<String> getTextFromFile(Path path) {
        if (Files.exists(path)) {
            var encoding = fileUtilsService.getEncoding(path);
            try {
                var bytes = Files.readAllBytes(path);
                return Optional.of(new String(bytes, Charset.forName(encoding)));
            } catch (IOException e) {
                log.warn("getTextFromFile: Problem with reading path: {} with encoding: {}", path, encoding);
            }
        }
        return Optional.empty();
    }

    private Optional<URL> getUrl(String urlString) {
        try {
            return Optional.of(new URL(urlString));
        } catch (MalformedURLException | NullPointerException e) {
            log.warn("Url for string {} can't be created", urlString);
        }
        return Optional.empty();
    }
}
