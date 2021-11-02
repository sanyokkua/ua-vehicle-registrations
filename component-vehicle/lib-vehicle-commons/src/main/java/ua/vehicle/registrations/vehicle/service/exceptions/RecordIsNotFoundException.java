package ua.vehicle.registrations.vehicle.service.exceptions;

public class RecordIsNotFoundException extends RuntimeException {

    public RecordIsNotFoundException(String recordId) {
        super(String.format("There is no record with ID: %s", recordId));
    }

    public RecordIsNotFoundException(Long recordId) {
        super(String.format("There is no record with ID: %d", recordId));
    }

    public RecordIsNotFoundException(Object recordId) {
        super(String.format("There is no record with ID: %s", recordId.toString()));
    }
}
