package ua.vehicle.registrations.vehicle.service.erros;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(String recordId) {
        super(String.format("There is no record with ID: %s", recordId));
    }
}
