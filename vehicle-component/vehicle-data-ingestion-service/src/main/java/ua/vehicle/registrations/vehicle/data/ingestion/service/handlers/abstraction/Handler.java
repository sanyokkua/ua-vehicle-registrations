package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction;

public interface Handler<T> {
    void handle(T obj);
}
