package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction;

public interface Handler<T> {

    void handle(T recordToHandle);
}
