package ua.vehicle.registrations.vehicle.data.ingestion.service.services;

import com.google.gson.Gson;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CsvUtilsService {
    protected final Gson gson;
    protected final FileUtilsService fileUtilsService;

    public Stream<CSVRecord> parseCsvFile(@NonNull Path input) {
        var encoding = fileUtilsService.getEncoding(input);
        var delimiter = getDelimiter(input);
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                                               .setDelimiter(delimiter)
                                               .setHeader()
                                               .setSkipHeaderRecord(true)
                                               .build();
        try {
            return CSVParser.parse(input, Charset.forName(encoding), csvFormat).stream();
        } catch (IOException e) {
            log.warn("CSV file {} can't be processed, error - {}", input, e);
        }

        return Stream.empty();
    }

    private char getDelimiter(@NonNull Path textFile) {
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
            log.warn("Problem with recognizing delimiter. Default delimiter will be returned", e);
        }
        return ',';
    }

    public Optional<CsvVehicleRegistrationRecordDto> mapCsvRecordToVehicleRegistrationRecord(CSVRecord csv) {
        try {
            var recordAsMap = csv.toMap();
            var normalizedRecordMap = new HashMap<String, String>();
            recordAsMap.forEach((key, value) -> {
                var normalizedValue = normalize(key, value);
                normalizedRecordMap.put(key.toUpperCase(), normalizedValue);
            });

            var finalizedRecordMap = fixSources(normalizedRecordMap);
            var json = gson.toJson(finalizedRecordMap);
            return Optional.ofNullable(gson.fromJson(json, CsvVehicleRegistrationRecordDto.class));
        } catch (Exception ex) {
            log.warn("Exception occurred during mapping of csv to dto", ex);
            return Optional.empty();
        }
    }

    private String normalize(String key, String value) {
        var normalizationMap = new HashMap<String, Function<String, String>>();
        normalizationMap.put("PERSON", this::normalizeString);
        normalizationMap.put("OPER_CODE", this::normalizeInteger);
        normalizationMap.put("OPER_NAME", this::normalizeString);
        normalizationMap.put("D_REG", this::normalizeString);
        normalizationMap.put("DEP_CODE", this::normalizeInteger);
        normalizationMap.put("DEP", this::normalizeString);
        normalizationMap.put("BRAND", this::normalizeString);
        normalizationMap.put("MODEL", this::normalizeString);
        normalizationMap.put("MAKE_YEAR", this::normalizeInteger);
        normalizationMap.put("COLOR", this::normalizeString);
        normalizationMap.put("KIND", this::normalizeString);
        normalizationMap.put("BODY", this::normalizeString);
        normalizationMap.put("PURPOSE", this::normalizeString);
        normalizationMap.put("REG_ADDR_KOATUU", this::normalizeString);
        normalizationMap.put("FUEL", this::normalizeString);
        normalizationMap.put("CAPACITY", this::normalizeInteger);
        normalizationMap.put("OWN_WEIGHT", this::normalizeInteger);
        normalizationMap.put("TOTAL_WEIGHT", this::normalizeInteger);
        normalizationMap.put("N_REG_NEW", this::normalizeString);
        normalizationMap.put("VIN", this::normalizeString);
        var normalizationFunction = normalizationMap.get(key.toUpperCase().trim());
        return normalizationFunction.apply(value);
    }

    private String normalizeString(String value) {
        if (Objects.isNull(value)) {
            return "N/A";
        }
        if ("NULL".equalsIgnoreCase(value)) {
            return "N/A";
        }
        return StringUtils.trimToEmpty(value.toUpperCase());
    }

    private String normalizeInteger(String value) {
        if (Objects.isNull(value)) {
            return "0";
        }
        if ("NULL".equalsIgnoreCase(value)) {
            return "0";
        }
        if (value.contains(".")) {
            var indexOfDot = value.indexOf(".");
            return StringUtils.trimToEmpty(value.substring(0, indexOfDot));
        }
        return StringUtils.trimToEmpty(value);
    }

    private Map<String, String> fixSources(Map<String, String> csvRecordMap) {
        var finalizedRecordMap = new HashMap<>(csvRecordMap);
        var opName = fixDuplication(csvRecordMap.get("OPER_NAME"), csvRecordMap.getOrDefault("OPER_CODE", ""));
        var brand = fixDuplication(csvRecordMap.get("BRAND"), csvRecordMap.getOrDefault("MODEL", ""));
        var depName = fixDuplication(csvRecordMap.get("DEP"), csvRecordMap.getOrDefault("DEP_CODE", ""));

        finalizedRecordMap.put("OPER_NAME", opName);
        finalizedRecordMap.put("BRAND", brand);
        finalizedRecordMap.put("DEP", depName);

        return finalizedRecordMap;
    }

    private String fixDuplication(String source, String duplication) {
        var src = StringUtils.trim(source);
        var fixed = StringUtils.replace(src, duplication.trim(), "");
        if (fixed.startsWith("-") || fixed.startsWith(" -")) {
            var indexOfDot = fixed.indexOf("-");
            return StringUtils.trimToEmpty(fixed.substring(indexOfDot));
        }
        return StringUtils.trimToEmpty(fixed);
    }
}
