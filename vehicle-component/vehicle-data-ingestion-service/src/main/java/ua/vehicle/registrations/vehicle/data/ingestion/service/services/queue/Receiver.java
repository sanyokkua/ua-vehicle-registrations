package ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue;

public interface Receiver<T> {

    void process(String message);

    T map(String message);
}
