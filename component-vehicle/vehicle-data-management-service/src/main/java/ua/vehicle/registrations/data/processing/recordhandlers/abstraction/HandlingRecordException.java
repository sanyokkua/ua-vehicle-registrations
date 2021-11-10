package ua.vehicle.registrations.data.processing.recordhandlers.abstraction;

public class HandlingRecordException extends RuntimeException {

    public HandlingRecordException(String message, Throwable cause) {
        super(message, cause);
    }
}
