package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction;

public class HandlingRecordException extends RuntimeException {

    public HandlingRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
