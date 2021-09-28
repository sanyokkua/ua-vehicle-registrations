package ua.vehicle.registrations.vehicle.data.ingestion.service.tasks;

public interface Task<I, O> {
    O process(I input);
}