package ua.vehicle.registrations.vehicle.data.ingestion.service.services.tasks;

public interface Task<I, O> {
    O process(I input);
}