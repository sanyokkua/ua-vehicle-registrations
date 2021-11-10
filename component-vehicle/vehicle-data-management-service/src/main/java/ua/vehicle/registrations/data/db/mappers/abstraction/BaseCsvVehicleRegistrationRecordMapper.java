package ua.vehicle.registrations.data.db.mappers.abstraction;

import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.mappers.InputMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public interface BaseCsvVehicleRegistrationRecordMapper<O> extends InputMapper<CsvVehicleRegistrationRecordDto, O> {

    default LocalDate dateFromString(String input) {
        var formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd.MM.yyyy]");
        try {
            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}
